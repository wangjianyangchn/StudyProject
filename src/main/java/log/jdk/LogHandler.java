package log.jdk;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class LogHandler {

	private static Logger logger = Logger.getLogger(LogHandler.class.getName());

	public static void main(String[] args) throws SecurityException,
			IOException {

		// 1.ConsoleHandler
		// 2.FileHandler
		Handler handler = new FileHandler(
				"src/main/java/log/jdk/myapp-log.%u.%g.txt", true);
		logger.addHandler(handler);
		logger.info("hello,file handler");
		// 3.StreamHandler
		// 4.SocketHandler
		// 5.MemoryHandler

	}
}
