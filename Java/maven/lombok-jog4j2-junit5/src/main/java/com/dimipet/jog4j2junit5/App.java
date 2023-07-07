package com.dimipet.jog4j2junit5;

import com.dimipet.jog4j2junit5.model.Student;
import com.dimipet.jog4j2junit5.service.StudentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {
	public static void main(String[] args) {
		
		log.trace("App TRACE");
		log.debug("App DEBUG");
		log.info("App INFO");
		log.warn("App WARN");
		log.error("App ERROR");
		log.fatal("App FATAL");
		
		Student.saySomething();
		StudentService.serviceSomething();
	}
}
