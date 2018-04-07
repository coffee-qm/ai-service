package com.coffee.ai.service.sdm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/conf/spring/applicationContext.xml")
public class TaskSvcTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private TaskSvc service;

	@Test
	//标注测试方法
	public void testHasMatchUser() {
		System.out.println(service.cnt());
	}
}
