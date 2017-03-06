package servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SimpleHttpContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("SimpleHttpContextListener.contextInitialized()");
	}

}
