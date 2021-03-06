package top.keepmoving.kmweb.web.quartz.domain;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import top.keepmoving.kmweb.common.CustomerDateAndTimeDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-05-23
 * <p>@Description:
 */
@Entity()
@Table(name = "schedule_job")
public class ScheduleJob implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String className;

	private String cronExpression;

	private String jobName;

	private String jobGroup;

	private String triggerName;

	private String triggerGroup;

	private Boolean pause;

	private Boolean enable;

	private String description;

	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@Temporal(value = TemporalType.DATE)
	private Date createTime;

	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@Temporal(value = TemporalType.DATE)
	private Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroup() {
		return triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public Boolean getPause() {
		return pause;
	}

	public void setPause(Boolean pause) {
		this.pause = pause;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
