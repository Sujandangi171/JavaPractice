package myFirstWebApplication;

import java.io.IOException;
import java.sql.SQLException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myFirstWebApplication.model.Product;
import myFirstWebApplication.model.ProductDao;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	ProductDao pDao = new ProductDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		try {
			Product pd = pDao.getOne(id);
			req.setAttribute("product",pd);
			req.setAttribute("msg","updateProduct");
			
		} catch (ClassNotFoundException | SQLException e) {
			req.setAttribute("msg","Product Not Found");
			e.printStackTrace();
		}
		req.getRequestDispatcher("products.jsp").forward(req,resp);
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product pd = new Product(
					Integer.parseInt(req.getParameter("id")),
					req.getParameter("name"),
					req.getParameter("manufacturer"),
					req.getParameter("description"),
					Float.parseFloat(req.getParameter("price")),
					req.getParameter("inStock").equalsIgnoreCase("true")?true:false				
				);
		int i=0;
		String msg="Update Failed!";
		try {
			i=pDao.update(pd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1) {
			msg="Product Updated Successfully!";
		}
		resp.sendRedirect("products");
		
		
	}

}
