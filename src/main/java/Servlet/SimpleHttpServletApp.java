package Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class SimpleHttpServletApp {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler();

		context.addServlet(SimpleHttpServlet.class, "/simple");
		server.setHandler(context);
		server.start();

	}
}
