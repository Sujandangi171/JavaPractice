package myFirstWebApplication;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/sessionHandler")
public class SessionHandlerServlet extends HttpServlet implements Servlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
		HttpSession session = request.getSession();
		ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
		if(items==null) {
			 items = new ArrayList<>();
		}
		items.add(item);
		session.setAttribute("items", items);
		//request.setAttribute("items",items);
		System.out.println(session);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
