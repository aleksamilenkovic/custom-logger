package logging.logger;

import java.util.concurrent.ConcurrentHashMap;

public class LoggerDelegator {
	private static LoggerDelegator delegator;
	private static ConcurrentHashMap<String, CustomLogger> loggers;

	public static LoggerDelegator getLogDelegator() {
		if (delegator == null) {
			initializeDelegator();
		}
		return delegator;
	}

	private static void initializeDelegator() {
		delegator = new LoggerDelegator();
		loggers = new ConcurrentHashMap<String, CustomLogger>();
		loggers.put(CustomLogger.DEFAULT_LOGGER, CustomLogger.getDefaultLogger());
	}

	public CustomLogger delegateLogger(String name) {
		CustomLogger logger = name == null ? loggers.get(CustomLogger.DEFAULT_LOGGER) : loggers.get(name);
		if (logger == null) {
			logger = createLogger(name);
		}
		return logger;
	}

	private CustomLogger createLogger(String name) {
		CustomLogger logger = new CustomLogger(name, false);
		loggers.put(name, logger);
		return logger;
	}

}
