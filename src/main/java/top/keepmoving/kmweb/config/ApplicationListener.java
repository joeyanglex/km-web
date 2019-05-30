package top.keepmoving.kmweb.config;

import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.keepmoving.kmweb.service.JobService;
import top.keepmoving.kmweb.web.quartz.domain.ScheduleJob;
import top.keepmoving.kmweb.web.quartz.exception.ServiceException;
import top.keepmoving.kmweb.web.quartz.util.ScheduleUtil;

import java.util.List;

@Component
public class ApplicationListener implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JobService jobService;

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... args) throws Exception {

        // Run schedule job when Application startup
        List<ScheduleJob> scheduleJobList = jobService.getAllEnableJob();

        logger.info("Run schedule job when Application startup: {}", scheduleJobList.size());
        for (ScheduleJob scheduleJob : scheduleJobList) {
            try {
                CronTrigger cronTrigger = ScheduleUtil.getCronTrigger(scheduler, scheduleJob);
                if (cronTrigger == null) {
                    ScheduleUtil.createScheduleJob(scheduler, scheduleJob);
                } else {
                    ScheduleUtil.updateScheduleJob(scheduler, scheduleJob);
                }
                logger.info("Startup {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());
            } catch (ServiceException e) {
                logger.error("run", e);
            }
        }
    }
}
