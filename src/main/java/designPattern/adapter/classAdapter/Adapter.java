package designPattern.adapter.classAdapter;

public class Adapter extends Adaptee implements Target {

	public void method1() {
		System.out.println("Adapter.method1()");
	}

	public void method2() {
		super.method2();
	}

}
