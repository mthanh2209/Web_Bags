package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BagDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete_old_bag")
public class DeleteOldBag extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String em=req.getParameter("em");
			int id=Integer.parseInt(req.getParameter("id"));
			
			
			BagDAOImpl dao=new BagDAOImpl(DBConnect.getConn());
			
			boolean f=dao.oldBagDelete(em, "Old", id);
			    
			HttpSession session = req.getSession();
			
			
			if(f)
			{
				session.setAttribute("success", "Old Bag Delete successfully");
				resp.sendRedirect("old_bag.jsp");
			}else {
				session.setAttribute("success", "Sothing Wrong On Server");
				resp.sendRedirect("old_bag.jsp");
			}
			
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}

	
	
}
