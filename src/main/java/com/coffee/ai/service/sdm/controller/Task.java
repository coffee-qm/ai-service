package com.coffee.ai.service.sdm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.ai.service.sdm.model.TaskMo;
import com.coffee.ai.service.sdm.service.TaskSvc;

@RestController
@RequestMapping("/task")
public class Task {

	private final Logger LOG = LoggerFactory.getLogger(Task.class);

	@Autowired
	private TaskSvc svc;

	@RequestMapping("/cnt")
	public long cnt() {
		LOG.info("cnt.");
		return svc.cnt();
	}

	@RequestMapping("/query")
	public List<TaskMo> query() {
		return svc.query();
	}

	@RequestMapping("/load")
	public TaskMo load(final long id) {
		return svc.load(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@ModelAttribute final TaskMo mo) {
		svc.add(mo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute final TaskMo mo) {
		svc.update(mo);
	}
}
