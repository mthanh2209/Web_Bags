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
import com.entity.BagDtls;

@WebServlet("/editbooks")
public class EditBagsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
            int id=Integer.parseInt(req.getParameter("id"));
			String bagName = req.getParameter("bname");
			String price = req.getParameter("price");
			String status = req.getParameter("bstatus");

			BagDtls b=new BagDtls();
			b.setBagId(id);
			b.setBagName(bagName);
			b.setPrice(price);
			b.setStatus(status);
		 	
			BagDAOImpl dao =new BagDAOImpl(DBConnect.getConn());
			boolean f=dao.updateEditBags(b);
			
			HttpSession session =req.getSession();
			
			if(f) {
				session.setAttribute("sucMsg", "Update Bag successfully...");
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
