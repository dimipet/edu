package com.dimipet.jog4j2junit5.model;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Student {
	
	public static void saySomething() {
		log.trace("Student TRACE");
		log.debug("Student DEBUG");
		log.info("Student INFO");
		log.warn("Student WARN");
		log.error("Student ERROR");
		log.fatal("Student FATAL");
	}

}
