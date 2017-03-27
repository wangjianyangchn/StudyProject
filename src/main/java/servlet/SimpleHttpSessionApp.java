package servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionManager;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class SimpleHttpSessionApp {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler();

		SessionManager sessionManager = new HashSessionManager();
		sessionManager.addEventListener(new HttpSessionListener() {

			@Override
			public void sessionDestroyed(HttpSessionEvent se) {
				System.out
						.println("SimpleHttpSessionApp.main(...).new HttpSessionListener() {...}.sessionDestroyed()");
			}

			@Override
			public void sessionCreated(HttpSessionEvent se) {
				System.out
						.println("SimpleHttpSessionApp.main(...).new HttpSessionListener() {...}.sessionCreated()");
			}
		});
		context.setSessionHandler(new SessionHandler(sessionManager));

		context.addServlet(SimpleHttpSession.class, "/simple");
		server.setHandler(context);
		server.start();

	}
}
