package servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 *contextListener init() 
 *filter init()
 *servlet init()
 *filter doFilter()
 *servlet service()
 *servlet destroy()
 *filter destroy()
 *contextListener destory() 
 *
 */
public class SimpleHttpContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("SimpleHttpContextListener.contextDestroyed()");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("SimpleHttpContextListener.contextInitialized()");
	}

}
