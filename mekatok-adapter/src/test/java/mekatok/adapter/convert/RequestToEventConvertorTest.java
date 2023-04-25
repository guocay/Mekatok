package mekatok.adapter.convert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RequestToEventConvertorTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestToEventConvertorTest.class);

	@BeforeEach
	void setUp() {
		LOGGER.info("BeforeEach");
	}

	@AfterEach
	void tearDown() {
		LOGGER.info("tearDown");
	}

	@BeforeAll
	static void beforeAll() {
		LOGGER.info("beforeAll");
	}

	@AfterAll
	static void afterAll() {
		LOGGER.info("afterAll");
	}

	@Test
	void test() {
		LOGGER.info("test");
	}

	@Test
	void test1() {
		LOGGER.info("test1");
	}
}
