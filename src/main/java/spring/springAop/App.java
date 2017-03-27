package spring.springAop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.springCore.beanLifeCycle.Person;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/spring/springAop/application.xml");

		UserService service = applicationContext.getBean(UserService.class);

		service.getById();

		applicationContext.registerShutdownHook();
	}
}
