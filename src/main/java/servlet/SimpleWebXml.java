package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleWebXml extends HttpServlet {

	private static final long serialVersionUID = 7307451084329916210L;

	public SimpleWebXml() {
		System.out.println("SimpleWebXml.SimpleWebXml()");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("SimpleWebXml.init()");
	}

	@Override
	public void destroy() {
		System.out.println("SimpleWebXml.destroy()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext globalContext = req.getServletContext();

		System.out.println("SimpleWebXml.doGet()");
		resp.getWriter().print(
				"webapp:" + globalContext.getInitParameter("key")
						+ this.getInitParameter("name"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

}
