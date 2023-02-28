package com.jhart;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootDemoApplicationTest {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
    void contextLoads(ApplicationContext context) {
	    assertThat(context).isNotNull();
	    log.info("SpringBootDemoApplicationTest - contextLoads(ApplicationContext context) executed");
	}
	
	@Test
	void contextLoads() {
	    log.info("SpringBootDemoApplicationTest - contextLoads() executed");
	}
	

}
