package mekatok.core.util.concurrent;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
class ThreadPoolBuilderTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolBuilderTest.class);

	@Test
	public void test() {
		ExecutorService service = ThreadPoolBuilder.builder()
			.corePoolSize(10).maximumPoolSize(20).maxQueueSize(100)
			.threadName("").reject(new ThreadPoolExecutor.DiscardPolicy()).build();
		LOGGER.info("this is ok!");
	}

}
