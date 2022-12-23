package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BagDAOImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.BagDtls;
import com.entity.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int bid=Integer.parseInt(req.getParameter("bid"));
			int uid=Integer.parseInt(req.getParameter("uid"));
			
			BagDAOImpl dao=new BagDAOImpl(DBConnect.getConn());
			BagDtls b=dao.getBagById(bid);
			
			Cart c=new Cart();
			c.setBid(bid);
			c.setUserId(uid);
			c.setBagName(b.getBagName());	
            c.setPrice(Double.parseDouble(b.getPrice()));
            c.setTotalPrice(Double.parseDouble(b.getPrice()));
            
            
            CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConn());
            boolean f=dao2.addCart(c);
            
            
            HttpSession session= req.getSession();
            
            
            if(f)
            {
            	session.setAttribute("addCart", "Bag Added to Cart ");
            	resp.sendRedirect("all_new_bag.jsp");
            	
            }else {
            	session.setAttribute("failed", "Something wrong on server ");
            	resp.sendRedirect("all_new_bag.jsp");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
