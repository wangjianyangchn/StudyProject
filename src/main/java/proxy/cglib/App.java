package proxy.cglib;

public class App {

	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		Person person = (Person) proxy.newProxy(new Person());
		person.eat();
	}
}
