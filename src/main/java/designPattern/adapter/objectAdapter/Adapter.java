package designPattern.adapter.objectAdapter;

public class Adapter implements Target {

	Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	public void method1() {
		System.out.println("Adapter.method1()");
	}

	public void method2() {
		adaptee.method2();
	}

}
