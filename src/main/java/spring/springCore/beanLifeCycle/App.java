package spring.springCore.beanLifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/spring/springCore/beanLifeCycle/application.xml");
		Person person = applicationContext.getBean(Person.class);
		System.out.println("---------------" + person.getBeanName());
		System.out.println("---------------" + person);
		System.out.println("---------------"
				+ person.getBeanFactory().getBean(person.getBeanName()));
		System.out.println("---------------"
				+ person.getApplicationContext().getBean(person.getBeanName()));
		applicationContext.registerShutdownHook();

	}
}
