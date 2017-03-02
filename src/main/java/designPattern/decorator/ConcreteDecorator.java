package designPattern.decorator;

public class ConcreteDecorator extends Decorator implements Component {

	public ConcreteDecorator(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		super.operation();
		System.out.println("ConcreteDecorator.operation()");
	}

}
