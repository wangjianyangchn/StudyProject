package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleHttpRequest extends HttpServlet {

	private static final long serialVersionUID = -332088581781071768L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Parameter
		String name = request.getParameter("name");
		System.out.println("name:" + name);
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String key : parameterMap.keySet()) {
			String[] values = parameterMap.get(key);
			for (String value : values) {
				System.out.println("key:" + key + " value:" + value);
			}
		}
		// RequestDispatcher
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/another");
		requestDispatcher.forward(request, response);

		// HttpSession session = request.getSession();
		String contentLength = request.getHeader("Content-Length");

		InputStream requestBodyInput = request.getInputStream();

		// ServletContext context = req.getSession().getServletContext();

		Cookie[] cookies = request.getCookies();

		response.getWriter().print("<h1>httpServlet:doGet</h1>");

	}

}
