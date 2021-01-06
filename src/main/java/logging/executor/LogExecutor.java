package logging.executor;

import logging.Message;

public abstract class LogExecutor {
	private String name;
	
	public LogExecutor(String name) {
		this.name = name;
	}
	
	public abstract void doLog(Message message);
	
	public String getName() {
		return this.name;
	}
	
	void setName(String name) {
		this.name = name;
	}
}
