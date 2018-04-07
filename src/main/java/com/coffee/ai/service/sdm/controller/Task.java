package com.coffee.ai.service.sdm.controller;

import java.util.List;

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

	@Autowired
	private TaskSvc svc;

	@RequestMapping("/cnt")
	public long cnt() {
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
	public void add(@ModelAttribute("mo") final TaskMo mo) {
		System.out.println(mo);
		svc.add(mo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(final TaskMo mo) {
		svc.update(mo);
	}
}
