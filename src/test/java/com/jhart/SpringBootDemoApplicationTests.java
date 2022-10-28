package com.jhart;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.jhart.aop.TaskManagerAspect;


@SpringBootTest
class SpringBootDemoApplicationTests {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void contextLoads() {
		log.info("running contextLoads");
	}
	
	/*
	 * @Test void contextLoads(ApplicationContext context) {
	 * assertThat(context).isNotNull();
	 * log.info("successfully executed context assertions"); }
	 * 
	 * @Test void loadTaskManagerAspect(ApplicationContext context) {
	 * assertThat(context.getBean(TaskManagerAspect.class)).isNotNull();
	 * log.info("successfully validated TaskManagerAspect is created"); }
	 */

}
