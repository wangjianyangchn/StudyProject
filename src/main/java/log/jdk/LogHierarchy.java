package log.jdk;

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

	public static void main(String[] args) {
		getParent();
	}
}
