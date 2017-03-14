package log.jdk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogManagers {

	private static Logger logger = Logger.getLogger(LogManagers.class.getName());
	
	public static void main(String[] args) {
		LogManager manager = LogManager.getLogManager();

		try {
			manager.readConfiguration(new FileInputStream("src/main/java/log/jdk/log.properties"));
			logger.warning("this is a log");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
