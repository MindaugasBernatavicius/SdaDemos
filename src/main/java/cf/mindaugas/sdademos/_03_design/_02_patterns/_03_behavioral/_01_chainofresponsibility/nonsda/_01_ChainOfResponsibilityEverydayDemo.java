package cf.mindaugas.sdademos._03_design._02_patterns._03_behavioral._01_chainofresponsibility.nonsda;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class _01_ChainOfResponsibilityEverydayDemo {

	private static final Logger logger = Logger
			.getLogger(_01_ChainOfResponsibilityEverydayDemo.class.getName());
	
	public static void main(String[] args) {
		//level to log at
		logger.setLevel(Level.FINER);
		
		ConsoleHandler handler = new ConsoleHandler();
		//level to publish at
		handler.setLevel(Level.FINER);
		logger.addHandler(handler);

		ConsoleHandler handler2 = new ConsoleHandler();
		handler2.setLevel(Level.FINEST);
		logger.addHandler(handler2);

		// TODO :: http://tutorials.jenkov.com/java-logging/handlers.html

		//this one won't print since we don't have handler for this level of logging
		// logger.finest("Finest level of logging"); // this will not print
		logger.finer("Finer level, but not as fine as finest");
		// logger.fine("Fine, but not as fine as finer or finest");

		// Fine message will be handled by all handlers
		// Finer - by finer and finest handlers
		// Finest - by only finest
	}
}
