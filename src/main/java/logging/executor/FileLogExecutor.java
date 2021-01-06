package logging.executor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import logging.Message;

public class FileLogExecutor extends LogExecutor{
	private String fileName;
    ReentrantLock lock = new ReentrantLock();

	public FileLogExecutor(String fileName) {
		super(fileName +"- logging");
		this.fileName = fileName;
	}

	@Override
	public void doLog(Message message) {
		FileWriter fw = null;
		lock.lock();
		try{	
		    String filename= String.format("%s-%s.txt", fileName, message.getDate());
		    fw = new FileWriter(filename, true); //the true will append the new data
		    fw.write(message.formatMessage() + "\n"); //appends the string to the file
			fw.close();
		}
		catch(IOException ioe){
		    System.err.println("IOException: " + ioe.getMessage());
		}finally {
			lock.unlock();
		}
	}

}
