package log.jdk;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogLevels {

	private static Logger logger = Logger.getLogger(LogLevels.class.getName());

	public static void main(String[] args) {
		// 1.log lever
		// SEVERE
		// WARNING
		// INFO
		// CONFIG
		// FINE
		// FINER
		// FINEST

		// 2.set lever
		// logger.setLevel(Level.INFO);
		logger.log(Level.INFO, "logLevel");
	}
}
