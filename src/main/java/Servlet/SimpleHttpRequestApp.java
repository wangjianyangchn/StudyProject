package Servlet;

import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class SimpleHttpRequestApp {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler();

		context.addServlet(SimpleHttpRequest.class, "/simple");
		context.addServlet(new ServletHolder(new HttpServlet() {
		}), "/another");

		server.setHandler(context);
		server.start();

	}
}
