package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

@WebServlet("/register")
public class RegisterSevlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("fname");
			String email = request.getParameter("email");
			String phno = request.getParameter("phno");
			String password = request.getParameter("password");
			String check = request.getParameter("check");
			
			User us = new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			us.setPassword(password);
			
			HttpSession session = request.getSession();
			
			if(check!=null) {
				UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
				boolean f = dao.userRegister(us);
				
				if(f) {
					//System.out.println("User Register Success!!!");
					session.setAttribute("succMsg", "Registration Successfully...");
					response.sendRedirect("register.jsp");
				}else {
					//System.out.println("Something Wrong on server...");
					session.setAttribute("failedMsg", "Something Wrong on server...");
					response.sendRedirect("register.jsp");
				}
			}else {
				//System.out.println("Please Check...");
				session.setAttribute("failedMsg", "Please Check...");
				response.sendRedirect("register.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
