package log.jdk;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExamples {
	private static final Logger logger = Logger.getLogger(LoggingExamples.class
			.getName());

	public static void operate() {
		logger.log(Level.INFO, "hello logging,{0} {1}", new String[] { "hello",
				"world" });
		logger.log(Level.INFO, "hello logging:", new RuntimeException("error"));
	}

	public static void main(String[] args) {
		operate();
	}
}
