package log.jdk;

import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogHierarchy {
	@SuppressWarnings("unused")
	private static Logger logger1 = Logger.getLogger("");
	private static Logger logger2 = Logger.getLogger("log");
	private static Logger logger3 = Logger.getLogger("log.jdk");
	private static Logger logger4 = Logger.getLogger(LogHierarchy.class.getName());

	public static void getParent() {
		// Hierarchy:""-->log-->jdk-->HierarchyExamples
		System.out.println(logger4.getParent().getName());
		System.out.println(logger3.getParent().getName());
		System.out.println(logger2.getParent().getName());
	}

	// filter,handler 会向上传递
	public static void hierarchy() {
		Logger logger = Logger.getLogger("");
		Logger logger1 = Logger.getLogger("1");
		Logger logger1_2 = Logger.getLogger("1.2");

		logger1.addHandler(new ConsoleHandler());
		logger1.setFilter(new Filter() {
			@Override
			public boolean isLoggable(LogRecord record) {
				return false;
			}
		});
		logger1.setLevel(Level.WARNING);
		logger1_2.addHandler(new ConsoleHandler());

		logger.info("msg:");
		logger1.info("msg: 1");
		logger1_2.info("msg: 1.2");
	}

	public static void main(String[] args) {
		hierarchy();
	}
}
