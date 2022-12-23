package com.admin.servlet;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.jni.File;

import com.DAO.BagDAOImpl;
import com.DB.DBConnect;
import com.entity.BagDtls;

@WebServlet("/add_bags")
@MultipartConfig
public class BagsAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String bagName = req.getParameter("bname");
			String price = req.getParameter("price");
			String categories = req.getParameter("btype");
			String status = req.getParameter("bstatus");
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();

			BagDtls b = new BagDtls(bagName, price, categories, status, fileName, "admin");
			BagDAOImpl dao = new BagDAOImpl(DBConnect.getConn());

			boolean f = dao.addBags(b);

			HttpSession session = req.getSession();
			if (f) {
				String path = getServletContext().getRealPath("") + "bag";

				java.io.File file =new java.io.File(path);
				part.write(path+java.io.File.separator+fileName);
				
				session.setAttribute("succMsg", "Bag Add Successfully");
				resp.sendRedirect("admin/add_bags.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on Server");
				resp.sendRedirect("admin/add_bags.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
