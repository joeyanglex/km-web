package top.keepmoving.kmweb.service;

import top.keepmoving.kmweb.web.quartz.domain.ScheduleJob;
import top.keepmoving.kmweb.web.quartz.exception.ServiceException;

import java.util.List;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-05-24
 * <p>@Description:
 */
public interface JobService {

	List<ScheduleJob> getAllEnableJob();

	ScheduleJob select(Long jobId) throws ServiceException;

	boolean delete(Long jobId) throws ServiceException;

	List<ScheduleJob> getAllJob();

	ScheduleJob update(Long jobId, ScheduleJob scheduleJob) throws ServiceException;

	boolean add(ScheduleJob scheduleJob) throws ServiceException;

	boolean resume(Long jobId) throws ServiceException;

	boolean pause(Long jobId) throws ServiceException;

	boolean run(Long jobId) throws ServiceException;
}
