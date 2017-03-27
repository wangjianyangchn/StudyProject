package log.jdk;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogFilter {
	private static Logger logger = Logger.getLogger(LogFilter.class.getName());

	public static void main(String[] args) {
		MyFilter filter = new MyFilter();
		logger.setFilter(filter);
		logger.log(Level.WARNING, "hello filter");
	}

}

class MyFilter implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {
		if (record.getLevel() == Level.INFO)
			return true;
		return false;
	}
}