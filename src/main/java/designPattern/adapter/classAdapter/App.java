package designPattern.adapter.classAdapter;

public class App {

	public static void main(String[] args) {

		Adapter adapter = new Adapter();

		adapter.method1();
		adapter.method2();
	}

}

class Util {
	public Target target;

	public Util(Target target) {
		this.target = target;
	}
}
