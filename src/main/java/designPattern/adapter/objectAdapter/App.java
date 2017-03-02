package designPattern.adapter.objectAdapter;

public class App {

	public static void main(String[] args) {
		
		Target adapter = new Adapter(new Adaptee());

		adapter.method1();
	}
}
