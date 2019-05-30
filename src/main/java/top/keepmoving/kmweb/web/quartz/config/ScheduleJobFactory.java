package top.keepmoving.kmweb.web.quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-05-23
 * <p>@Description:
 */
@Component
public class ScheduleJobFactory extends AdaptableJobFactory {

	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {

		Object jobInstance = super.createJobInstance(bundle);
		autowireCapableBeanFactory.autowireBean(jobInstance);
		return jobInstance;
	}
}
