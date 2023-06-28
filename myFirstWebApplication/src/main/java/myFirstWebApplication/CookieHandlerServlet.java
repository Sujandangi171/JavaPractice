package myFirstWebApplication;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/cookieHandler")
public class CookieHandlerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(int i=0; i<cookies.length; i++) {
			cookies[1].setValue(null);
			cookies[i].setMaxAge(0);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		System.out.println(name +" " +address);
		Cookie cookie1 = new Cookie ("name",name);
		Cookie cookie2 = new Cookie ("address",address);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
