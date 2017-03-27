package spring.springCore.beanScope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/spring/springCore/beanScope/application.xml");
		Person person = applicationContext.getBean(Person.class);
		Person person1 = applicationContext.getBean(Person.class);
		System.out.println("---------------" + person);
		System.out.println("---------------" + person1);
		applicationContext.registerShutdownHook();
	}
}
