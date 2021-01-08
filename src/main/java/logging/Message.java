package logging;

import java.text.SimpleDateFormat;
import java.util.Date;

import logging.logger.CustomLogger;

public class Message {
	private String msg;
	private Level level;
	private CustomLogger logger;
	private String date;
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public Message(String msg, Level level, CustomLogger logger) {
		this.msg = msg;
		this.level = level;
		this.logger = logger;
		this.date = df.format(new Date());
	}
	
	public String formatMessage() {
		return String.format(FORMAT_TEMPLATE, date, level.getValue(), msg, logger.getName());
	}
	
	private String FORMAT_TEMPLATE = "[%s] [%s] -> %s  |%s";

	public String getMsg() {
		return msg;
	}

	public Level getLevel() {
		return level;
	}

	public CustomLogger getLogger() {
		return logger;
	}

	public String getDate() {
		return date;
	}
	
	
}
