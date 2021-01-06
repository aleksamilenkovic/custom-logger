package logging.logger;


import logging.Level;
import logging.Message;
import logging.config.LoggingConfig;
import logging.executor.FileLogExecutor;
import logging.executor.LogExecutor;

public class CustomLogger {
    public static final String DEFAULT_LOGGER = "default";
    private static final CustomLogger defaultLogger = new CustomLogger(DEFAULT_LOGGER);
    private final boolean isDefaultLogger;
    private String name;
    private static LoggingConfig config = new LoggingConfig();
    private static final LogExecutor emptyExecutors[] = new LogExecutor[0];
    
    private CustomLogger(String name) {
    	this.name = name;
    	this.isDefaultLogger = true;
    }
    
    CustomLogger(String name, boolean isDefaultLogger){
    	this.name = name;
    	this.isDefaultLogger = isDefaultLogger;
    }
    
    public static CustomLogger getLogger(String name){
    	LoggerDelegator delegator = LoggerDelegator.getLogDelegator();
    	return delegator.delegateLogger(name);
    }
    
    public void log(Level level, String msg) {
    	Message message = new Message(msg, level, this);
    	doLog(message);
    }
    
    public void log(String msg) {
    		info(msg); // later set default logging e.g. info 
    }
    
    public void info(String msg) {
    	log(Level.INFO, msg);
    }
    
    public void warning(String msg) {
    	log(Level.WARNING, msg);
    }

    public void error(String msg) {
    	log(Level.ERROR, msg);
    }
    
    public void doLog(Message message) {
    	if(message!=null) {
    		final LogExecutor[] executors = config.getExecutors().toArray(emptyExecutors);
    		
    		for(LogExecutor ex : executors) {
    			ex.doLog(message);
    		}
    	}
    }
    
    public static void addFileExecutor(String fileName) {
    	config.addExecutor(new FileLogExecutor(fileName));
    }
    
    public static final CustomLogger getDefaultLogger() {
    	return defaultLogger;
    }

	public boolean isDefaultLogger() {
		return isDefaultLogger;
	}

	public String getName() {
		return name;
	}
    
    
}
