package servlet;

import java.io.IOException;

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
		// String name = request.getParameter("name");
		// System.out.println("name:" + name);
		// Map<String, String[]> parameterMap = request.getParameterMap();
		// for (String key : parameterMap.keySet()) {
		// String[] values = parameterMap.get(key);
		// for (String value : values) {
		// System.out.println("key:" + key + " value:" + value);
		// }
		// }

		// RequestDispatcher include forward
		// RequestDispatcher requestDispatcher = request
		// .getRequestDispatcher("/another");
		// requestDispatcher.include(request, response);

		// Session redis，mysql 集群
		// HttpSession session = request.getSession();
		// session.setAttribute("name", "session");
		// System.out.println(session.getId());

		// requeset header
		// String accept = request.getHeader("Accept");
		// System.out.println(accept);

		// InputStream requestBodyInput = request.getInputStream();

		// ServletContext 存储在的ServletContext属性可用于应用程序中的所有servlet
		// ServletContext context = request.getSession().getServletContext();
		// String serverInfo = context.getServerInfo();
		// System.out.println(serverInfo);

		// Cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			System.out.println(c.getMaxAge());
		}

		response.getWriter().print("<h1>httpServlet:request</h1>");

	}
}
