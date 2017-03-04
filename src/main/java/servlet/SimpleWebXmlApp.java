package servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class SimpleWebXmlApp {

	public static void main(String[] args) {
		Server server = new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setDescriptor("./src/main/java/servlet/web.xml");
		context.setResourceBase(".");
		server.setHandler(context);
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
