package com.coffee.ai.service.sdm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskMo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2919908881324723439L;

	private long id;
	private String name;
	private String description;
	private String developer;
	private int status;
	private long codesNum;
	private Date planedStartDate;
	private Date planedFinishDate;
	private Date actualStartDate;
	private Date actualFinishDate;
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

	public Date getPlanedStartDate() {
		return planedStartDate;
	}

	public void setPlanedStartDate(final Date planedStartDate) {
		this.planedStartDate = planedStartDate;
	}

	public Date getPlanedFinishDate() {
		return planedFinishDate;
	}

	public void setPlanedFinishDate(final Date planedFinishDate) {
		this.planedFinishDate = planedFinishDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(final Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualFinishDate() {
		return actualFinishDate;
	}

	public void setActualFinishDate(final Date actualFinishDate) {
		this.actualFinishDate = actualFinishDate;
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
