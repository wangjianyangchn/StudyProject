package spring.springAop;

public class LogService {

	public void beforeMethod() {
		System.out.println("LogService.beforeMethod()");
	}

	public void afterMethod() {
		System.out.println("LogService.afterMethod()");
	}
}
