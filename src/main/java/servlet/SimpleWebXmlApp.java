package servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class SimpleWebXmlApp {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setDescriptor("./src/main/java/servlet/web.xml");
		context.setResourceBase(".");
		server.setHandler(context);
		server.start();

		Thread.sleep(10000);
		server.stop();
	}
}
