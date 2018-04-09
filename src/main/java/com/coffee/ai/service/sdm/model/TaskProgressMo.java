package com.coffee.ai.service.sdm.model;

import com.coffee.common.base.model.BaseMo;

public class TaskProgressMo extends BaseMo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4551582596819836643L;

	private long taskId;
	private int rate;
	private String description;
	private long createTime;
	private long updateTime;
	private String userIp;

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(final long taskId) {
		this.taskId = taskId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(final int rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(final long createTime) {
		this.createTime = createTime;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(final long updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(final String userIp) {
		this.userIp = userIp;
	}
}
