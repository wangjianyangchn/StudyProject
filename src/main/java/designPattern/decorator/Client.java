package designPattern.decorator;

public class Client {

	public static void main(String[] args) {

		Component component = new ConcreteComponent();

		Component concreteComponent1 = new ConcreteDecorator(component);
		Component concreteComponent2 = new ConcreteDecorator(concreteComponent1);

		concreteComponent2.operation();
	}
}
