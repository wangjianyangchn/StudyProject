package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleServletFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("SimpleServletFilter.destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getParameterMap() != null) {
			System.out.println("SimpleServletFilter.doFilter(): parameter");
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("SimpleServletFilter.init()");
	}

}
