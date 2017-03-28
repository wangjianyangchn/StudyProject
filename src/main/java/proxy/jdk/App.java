package proxy.jdk;

public class App {

	public static void main(String[] args) {
		Service service = (Service) new JDKProxy().newProxy(new ServiceImpl());
		service.eat();
	}
}
