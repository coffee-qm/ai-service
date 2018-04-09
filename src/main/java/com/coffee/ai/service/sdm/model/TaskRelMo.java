package com.coffee.ai.service.sdm.model;

import com.coffee.common.base.model.BaseMo;

public class TaskRelMo extends BaseMo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8034526514908172348L;

	private int type;
	private long taskId;
	private long relId;
	private String description;
	private long createTime;
	private String userIp;

	public int getType() {
		return type;
	}

	public void setType(final int type) {
		this.type = type;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(final long taskId) {
		this.taskId = taskId;
	}

	public long getRelId() {
		return relId;
	}

	public void setRelId(final long relId) {
		this.relId = relId;
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

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(final String userIp) {
		this.userIp = userIp;
	}
}
