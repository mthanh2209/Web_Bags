package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BagDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete")
public class BagDeleteServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			
			BagDAOImpl dao=new BagDAOImpl(DBConnect.getConn());
			 
			boolean f=dao.deleteBags(id);
			

			HttpSession session =req.getSession();
			
			if(f) {
				session.setAttribute("sucMsg", "Delete Bag Successfully...");
				resp.sendRedirect("admin/all_bags.jsp");
			}else {
				session.setAttribute("failedMsg", "Some thing wrong on server...");
				resp.sendRedirect("admin/all_bags.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
