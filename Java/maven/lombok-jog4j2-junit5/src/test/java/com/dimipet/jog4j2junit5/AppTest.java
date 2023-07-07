package com.dimipet.jog4j2junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppTest {

	@Test
	public void shouldAnswerWithTrue() {
		log.trace("junit5 test TRACE");
		log.debug("junit5 test DEBUG");
		log.info("junit5 test INFO");
		log.warn("junit5 test WARN");
		log.error("junit5 test ERROR");
		log.fatal("junit5 test FATAL");
		assertTrue(true);
	}
}
