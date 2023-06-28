package myFirstWebApplication;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myFirstWebApplication.model.Product;
import myFirstWebApplication.model.ProductDao;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	       ProductDao pDao = new ProductDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = "Hello from product servlet";
		request.setAttribute("message", msg);
		try {
			List<Product> products = pDao.getAll();
			request.setAttribute("products", products);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Product pd =new Product(
				request.getParameter("name"),
				request.getParameter("manufacturer"),
				request.getParameter("description"),
				Float.parseFloat(request.getParameter("price")),
				request.getParameter("inStock").equalsIgnoreCase("true")?true:false
				);
		
		int i=0;
		try {
			i = pDao.save(pd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg;
		if(i==0) {
			msg="Product couldn't be added to the database!";
		}
		else {
			msg="Product added to the database!";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);		

	}

}
