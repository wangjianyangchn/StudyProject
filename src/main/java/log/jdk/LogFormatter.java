package log.jdk;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogFormatter {

	private static Logger logger = Logger.getLogger(LogFormatter.class
			.getName());

	public static void main(String[] args) {
		MyFormatter formatter = new MyFormatter();
		Handler handler = new ConsoleHandler();
		handler.setFormatter(formatter);
		logger.addHandler(handler);
		logger.log(Level.INFO, "logFormatter");
	}
}

class MyFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return "class:" + record.getSourceClassName()// 获取类名
				+ " mthod:" + record.getSourceMethodName() // 获取方法名
				+ " logLevel:" + record.getLevel()// 获取log级别
				+ " msg:" + record.getMessage() + "\n";
	}

}
