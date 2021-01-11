package logging.executor;

import logging.Message;

public class ConsoleLogExecutor extends LogExecutor {

	public ConsoleLogExecutor() {
		super("Console logging");
	}

	@Override
	public void doLog(Message message) {
		// here should be lock or synch
		synchronized (System.out) {
			System.out.println(message.formatMessage());
		}
	}

}
