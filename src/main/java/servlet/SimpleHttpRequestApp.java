package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionManager;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class SimpleHttpRequestApp {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler();

		SessionManager manager = new HashSessionManager();
		manager.addEventListener(new HttpSessionListener() {

			@Override
			public void sessionDestroyed(HttpSessionEvent arg0) {

			}

			@Override
			public void sessionCreated(HttpSessionEvent arg0) {

			}
		});
		context.setSessionHandler(new SessionHandler(manager));

		context.addServlet(SimpleHttpRequest.class, "/simple");
		context.addServlet(new ServletHolder(new HttpServlet(

		) {

			private static final long serialVersionUID = -8394328374737522353L;

			@Override
			protected void doGet(HttpServletRequest req,
					HttpServletResponse resp) throws ServletException,
					IOException {
				resp.getWriter().print("<h1>hello</h1>");
			}
		}), "/another");

		server.setHandler(context);
		server.start();

	}
}
