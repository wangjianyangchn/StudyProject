package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SimpleHttpSession extends HttpServlet {

	private static final long serialVersionUID = -4365041400923298190L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();// 有两个含义

		/**
		 * 1.在响应中发送一个cookie
		 *  分析浏览器响应头Response headers:Set-Cookie:"JSESSIONID=erl7f1b5b720131lwhodaq8cc;Path=/"
		 * 1)创建HttpSession对象，生成唯一Id
		 * 2)创建Cookie对象，与Id关联
		 * 3)在response中设置此Cookie
		 */

		/**
		 * 2.获取sesssion
		 * 分析浏览器请求头Request headers: Cookie:"JSESSIONID=1s7u1tue9hcftzzwrhdkdhsvi"
		 *  if(请求包含一个JESSIONID Cookie)
		 *  		找到与该JESSSION匹配的session
		 *  else
		 *   		创建一个Session对象
		 */
		
		// 1.为什么从request中获取session,而不是从response中获取
		// 从客户端获得一个session的对象,这个对象包含客户端持有的相关信息用来区别每个客户端.既然是从客户端就必须用请求对象来获取,因为一般都是客户端向服务器端发出的一个请求.所以用request对象

		// 2.若浏览器禁止Cookie
		// url重写,response.encodeURL(); 
		// 例子 resp.getWriter().print("<a href=\""+resp.encodeUrl("simple")+"\">click</a>");
		// 效果 http://localhost:8080/simple;jsessionid=1x5gvhs04p3jd1xx08noacakt0
		
		// 3.容器如何判断浏览器是否禁止Cookie,何时url重写
		//向客户放回第一个响应时，容器会同时尝试cookie和URL重写
		
		
		//4.设置session超时
		//1).session.setMaxInactiveInterval(20*60);
		//2).web.xml中配置
		//3).容器中配置
		String name = (String) session.getAttribute("name");
		if (name == null || "".equals("jim")) {
			System.out.println("name not exists!");
			session.setAttribute("name", "jim");
			
		} else {
			name = (String) session.getAttribute("name");
			System.out.println("name in session:" + name);
		}
		
	}
}
