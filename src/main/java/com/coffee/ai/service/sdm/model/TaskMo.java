package com.coffee.ai.service.sdm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskMo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2919908881324723439L;

	private long id;
	private String name;
	private String sn;
	private String description;
	private String developer;
	private int status;
	private long codesNum;
	private long createTime;
	private long updateTime;
	private long planedStartTime;
	private long planedFinishTime;
	private long actualStartTime;
	private long actualFinishTime;
	private List<Long> preTasks = new ArrayList<>();
	private List<Long> nxtTasks = new ArrayList<>();

	@Override
	public String toString() {
		final StringBuffer s = new StringBuffer();
		s.append("{");
		s.append("name:\"").append(name).append("\"");
		s.append("}");
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(final String sn) {
		this.sn = sn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(final String developer) {
		this.developer = developer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(final int status) {
		this.status = status;
	}

	public long getCodesNum() {
		return codesNum;
	}

	public void setCodesNum(final long codesNum) {
		this.codesNum = codesNum;
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

	public long getPlanedStartTime() {
		return planedStartTime;
	}

	public void setPlanedStartTime(final long planedStartTime) {
		this.planedStartTime = planedStartTime;
	}

	public long getPlanedFinishTime() {
		return planedFinishTime;
	}

	public void setPlanedFinishTime(final long planedFinishTime) {
		this.planedFinishTime = planedFinishTime;
	}

	public long getActualStartTime() {
		return actualStartTime;
	}

	public void setActualStartTime(final long actualStartTime) {
		this.actualStartTime = actualStartTime;
	}

	public long getActualFinishTime() {
		return actualFinishTime;
	}

	public void setActualFinishTime(final long actualFinishTime) {
		this.actualFinishTime = actualFinishTime;
	}

	public List<Long> getPreTasks() {
		return preTasks;
	}

	public void setPreTasks(final List<Long> preTasks) {
		this.preTasks = preTasks;
	}

	public List<Long> getNxtTasks() {
		return nxtTasks;
	}

	public void setNxtTasks(final List<Long> nxtTasks) {
		this.nxtTasks = nxtTasks;
	}
}
