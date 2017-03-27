package log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//log4j-->logback why? http://www.oschina.net/translate/reasons-to-prefer-logbak-over-log4j
public class TestLog {

	private static Logger logger = LoggerFactory.getLogger(TestLog.class);

	public static void main(String[] args) {

		logger.debug("This is debug message.");
		logger.info("This is info message.");
		logger.warn("This is warning message");
		logger.error("This is error message.");
	}
}
