package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BagDAOImpl;
import com.DB.DBConnect;
import com.entity.BagDtls;



@WebServlet("/add_old_bag")
@MultipartConfig
public class AddOldBag extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String bagName = req.getParameter("bname");
			String price = req.getParameter("price");
			String categories = "Old";
			String status ="Active";
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			
			String useremail=req.getParameter("user");
			

			BagDtls b = new BagDtls(bagName, price, categories, status, fileName,useremail);
			
			
			BagDAOImpl dao = new BagDAOImpl(DBConnect.getConn());

			boolean f = dao.addBags(b);

			HttpSession session = req.getSession();
			if (f) {
				String path = getServletContext().getRealPath("") + "bag";

				java.io.File file =new java.io.File(path);
				part.write(path+java.io.File.separator+fileName);
				
				session.setAttribute("succMsg", "Bag Sell Successfully");
				resp.sendRedirect("sell_bag.jsp");
			} else {
				session.setAttribute("failedMsg", "Sothing wrong on Server");
				resp.sendRedirect("sell_bag.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
