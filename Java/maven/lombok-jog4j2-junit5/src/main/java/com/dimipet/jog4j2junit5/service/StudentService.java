package com.dimipet.jog4j2junit5.service;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StudentService {
	
	public static void serviceSomething() {
		log.trace("Service TRACE");
		log.debug("Service DEBUG");
		log.info("Service INFO");
		log.warn("Service WARN");
		log.error("Service ERROR");
		log.fatal("Service FATAL");
	}

}
