package servlet;

import java.io.IOException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class SimpleServletFilterApp {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler();
		context.addFilter(SimpleServletFilter.class, "/*",
				EnumSet.of(DispatcherType.REQUEST));

		context.addServlet(new ServletHolder(new HttpServlet() {

			private static final long serialVersionUID = -4351399637962559766L;

			@Override
			public void init() throws ServletException {
				System.out
						.println("SimpleServletFilterApp.main(...).new HttpServlet() {...}.init()");
			}

			@Override
			public void destroy() {
				System.out
						.println("SimpleServletFilterApp.main(...).new HttpServlet() {...}.destroy()");
			}

			@Override
			protected void doGet(HttpServletRequest req,
					HttpServletResponse resp) throws ServletException,
					IOException {
				System.out
						.println("SimpleServletFilterApp.main(...).new HttpServlet() {...}.doGet()");
				resp.getWriter().print("<h1>hello</h1>");
			}
		}), "/simple");

		server.setHandler(context);
		server.start();

		Thread.sleep(10000);
		server.stop();
	}
}
