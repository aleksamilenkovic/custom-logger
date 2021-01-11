import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import logging.logger.CustomLogger;

public class TestLogger {
	private CustomLogger defaultLogger; 
	
	@Before
	public void creatingDefaultLogger() {
	    defaultLogger = CustomLogger.getDefaultLogger();
	}
	
	@Test
	public void defaultNotNull() {
		assertNotNull(defaultLogger);
		assertEquals(CustomLogger.DEFAULT_LOGGER, defaultLogger.getName());
	}
	
	@Test
	public void checkDefaultLoggerIsSingleton() {
		CustomLogger defaultLogger2 = CustomLogger.getDefaultLogger();
		assertEquals(defaultLogger, defaultLogger2);
	}
	
	@Test
	public void loggerNameNullStillDefault() {
		CustomLogger nullLogger = CustomLogger.getLogger(null);
		assertEquals(defaultLogger, nullLogger);
	}
	
	@Test
	public void testLoggerName() {
		CustomLogger testLogger = CustomLogger.getLogger(TestLogger.class.getName());
		assertEquals(TestLogger.class.getName(), testLogger.getName());
	}
	
}
