package logging.config;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Handler;

import logging.executor.ConsoleLogExecutor;
import logging.executor.FileLogExecutor;
import logging.executor.LogExecutor;

public class LoggingConfig {
	private final CopyOnWriteArrayList<LogExecutor> executors =
            new CopyOnWriteArrayList<LogExecutor>();
	
	public LoggingConfig() {
		executors.add(new ConsoleLogExecutor());
	}
	
	public LoggingConfig(String fileName) {
		executors.add(new FileLogExecutor(fileName));
	}
	
	public void addExecutor(LogExecutor executor) {
		if(executor!=null)
			executors.add(executor);
	}
	
	public CopyOnWriteArrayList<LogExecutor> getExecutors(){
		return executors;
	}
}
