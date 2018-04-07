package com.coffee.ai.service.sdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.ai.service.sdm.dao.TaskDao;
import com.coffee.ai.service.sdm.model.TaskMo;

@Service
public class TaskSvc {

	@Autowired
	private TaskDao dao;

	public long cnt() {
		return dao.cnt();
	}

	public List<TaskMo> query() {
		return dao.query();
	}

	public TaskMo load(final long id) {
		return dao.load(id);
	}

	public void add(final TaskMo mo) {
		dao.add(mo);
	}

	public void update(final TaskMo mo) {
		dao.update(mo);
	}
}
