package designPattern.decorator;

public class Decorator implements Component {

	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	public void operation() {
		System.out.println("Decorator.operation()");
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

}
