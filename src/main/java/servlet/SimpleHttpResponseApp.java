package servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class SimpleHttpResponseApp {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler();

		context.addServlet(SimpleHttpResponse.class, "/simple");
		server.setHandler(context);
		server.start();

	}
}
