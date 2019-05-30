package top.keepmoving.kmweb.domain;

import org.springframework.data.repository.CrudRepository;
import top.keepmoving.kmweb.web.quartz.domain.ScheduleJob;

import java.util.List;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-05-24
 * <p>@Description:
 */
public interface ScheduleJobRepository extends CrudRepository<ScheduleJob, Long> {

//	List<ScheduleJob> findAllByAndAvailable();

	List<ScheduleJob> findAllByEnable(boolean enable);

	List<ScheduleJob> findAll();
}
