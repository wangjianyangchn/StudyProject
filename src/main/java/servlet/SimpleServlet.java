package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *   sevlet初始化顺序
 *     init()
 *     service()
 *     destory();
 */
public class SimpleServlet extends GenericServlet {

	private static final long serialVersionUID = 1981615274010516505L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		this.log("this is a log:service method");
		System.out.println("SimpleServlet.service()");
		response.getWriter().print("<h1>hello!</h1>");
	}

	@Override
	public String getInitParameter(String name) {
		return super.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return super.getInitParameterNames();
	}

	@Override
	public ServletConfig getServletConfig() {
		return super.getServletConfig();
	}

	@Override
	public ServletContext getServletContext() {
		return super.getServletContext();
	}

	@Override
	public String getServletInfo() {
		return super.getServletInfo();
	}

	@Override
	public String getServletName() {
		return super.getServletName();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	public void log(String message, Throwable t) {
		super.log(message, t);
	}

	@Override
	public void log(String msg) {
		super.log(msg);
	}

	@Override
	public void destroy() {
		System.out.println("SimpleServlet.destroy()");
	}

	@Override
	public void init() throws ServletException {
		this.log("this is a log:init method");
		System.out.println("SimpleServlet.init()");
	}

}
