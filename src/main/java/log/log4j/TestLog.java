package log.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
//log4j: http://www.codeceo.com/article/log4j-usage.html
public class TestLog {

	private static Logger logger = Logger.getLogger(TestLog.class);

	public static void main(String[] args) {
		// 1.定义配置文件
		// 2.加载配置文件
		//BasicConfigurator.configure ();// 自动快速地使用缺省Log4j环境。 
//		PropertyConfigurator.configure("src/main/java/log/log4j/log4j.properties"); // 读取使用Java的特性文件编写的配置文件。
		DOMConfigurator.configure("src/main/java/log/log4j/log4j.xml"); // 读取XML形式的配置文件
		System.out.println("This is println message.");


		// 记录debug级别的信息
		logger.debug("This is debug message.");
		// 记录info级别的信息
		logger.info("This is info message.");
		// 记录error级别的信息
		logger.error("This is error message.");
	}
}
