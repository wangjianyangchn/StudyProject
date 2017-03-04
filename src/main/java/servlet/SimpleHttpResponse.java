package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleHttpResponse extends HttpServlet {

	private static final long serialVersionUID = -332088581781071768L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// setting status
		response.setStatus(200);
		// setting Headers
		response.setHeader("Content-Type", "text/html");
		// Writing
		PrintWriter writer = response.getWriter();
		writer.write("<html><body>GET/POST response</body></html>");

		// Writing Binary Data
		// OutputStream outputStream = response.getOutputStream();
		// outputStream.write(1);

		// Redirecting
		// response.sendRedirect("http://www.baidu.com");
	}

}
