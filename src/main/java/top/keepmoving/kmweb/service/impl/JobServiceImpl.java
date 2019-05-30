package top.keepmoving.kmweb.service.impl;

import com.google.common.collect.Lists;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.keepmoving.kmweb.domain.ScheduleJobRepository;
import top.keepmoving.kmweb.service.JobService;
import top.keepmoving.kmweb.web.quartz.domain.ScheduleJob;
import top.keepmoving.kmweb.web.quartz.exception.ServiceException;
import top.keepmoving.kmweb.web.quartz.util.ScheduleUtil;

import java.util.List;

/**
 * <p>@author: Vince
 * <p>@description: spring-boot-demos
 * <p>@since: v1.1
 * <p>@date: 2015-05-24
 **/
@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private ScheduleJobRepository jobMapper;

    @Autowired
    private Scheduler scheduler;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<ScheduleJob> getAllEnableJob() {
	    return jobMapper.findAllByEnable(Boolean.TRUE);

//	    return Lists.newArrayList();
    }

	@Override
    public ScheduleJob select(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = jobMapper.findById(jobId).get();
        if (scheduleJob == null) {
            throw new ServiceException("ScheduleJob:" + jobId + " not found");
        }
        return scheduleJob;
    }

    @Override
    @Transactional(rollbackFor = DataAccessException.class)
    public ScheduleJob update(Long jobId, ScheduleJob scheduleJob) throws ServiceException {

		// TODO 实现部分更新
        scheduleJob = jobMapper.save(scheduleJob);
        /*if (jobMapper.updateByPrimaryKey(scheduleJob) <= 0) {
            throw new ServiceException("Update product:" + jobId + "failed");
        }*/
        logger.info("Pause: {}", scheduleJob.getPause());

        ScheduleUtil.updateScheduleJob(scheduler, scheduleJob);

        return scheduleJob;
    }

    @Override
    @Transactional(rollbackFor = DataAccessException.class)
    public boolean add(ScheduleJob scheduleJob) throws ServiceException {
	    scheduleJob = jobMapper.save(scheduleJob);
        if (scheduleJob.getId() <= 0) {
            throw new ServiceException("Add product failed");
        }

        ScheduleUtil.createScheduleJob(scheduler, scheduleJob);

        return true;
    }

    @Override
    @Transactional(rollbackFor = DataAccessException.class)
    public boolean delete(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = select(jobId);

        jobMapper.deleteById(jobId);
        /*if (num <= 0) {
            throw new ServiceException("Delete product:" + jobId + "failed");
        }*/

        ScheduleUtil.deleteJob(scheduler, scheduleJob);

        return true;
    }

    @Override
    public List<ScheduleJob> getAllJob() {
        return jobMapper.findAll();
    }

    @Override
    public boolean resume(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, false);
        ScheduleUtil.resumeJob(scheduler, scheduleJob);
        return true;
    }

    @Override
    public boolean pause(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, true);
        ScheduleUtil.pauseJob(scheduler, scheduleJob);
        return true;
    }

    @Override
    public boolean run(Long jobId) throws ServiceException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, false);
        ScheduleUtil.run(scheduler, scheduleJob);
        return true;
    }


    private ScheduleJob updateScheduleJobStatus(Long jobId, Boolean isPause) throws ServiceException {
        ScheduleJob scheduleJob = select(jobId);
        scheduleJob.setPause(isPause);
        update(scheduleJob.getId(), scheduleJob);
        return scheduleJob;
    }
}
