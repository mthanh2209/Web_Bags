package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Bag_Order;

public class BagOrderImpl implements BagOrderDAO{

	private Connection conn;

	public BagOrderImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	
	public boolean saveOrder(List<Bag_Order> blist) {
		boolean f=false;
		try {
			
			String sql="insert into bag_order(order_id,user_name,email,address,phno,bag_name,price,payment) values(?,?,?,?,?,?,?,?)";
			
	        conn.setAutoCommit(false);
	        PreparedStatement ps=conn.prepareStatement(sql);
	        
	        
	        for(Bag_Order b:blist)
	        {
	        	ps.setString(1, b.getOrderId());
	        	ps.setString(2, b.getUsername());
	        	ps.setString(3, b.getEmail());
	        	ps.setString(4, b.getFulladd());
	        	ps.setString(5, b.getPhno());
	        	ps.setString(6, b.getBagName());
	        	ps.setString(8, b.getPrice());
	        	ps.setString(9, b.getPaymentType());
	        	ps.addBatch();
	        	
	        }
	        
	        int[] count=ps.executeBatch();
	        conn.commit();
	        f=true;
	        conn.setAutoCommit(true);
		
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		return f;
	}


	
	public List<Bag_Order> getBag(String email) {
	  List<Bag_Order> list=new ArrayList<Bag_Order>();
	  Bag_Order o=null;
		try {
			
			String sql="select * from bag_order where email=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				o=new Bag_Order();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUsername(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setBagName(rs.getString(7));
				o.setPrice(rs.getString(8));
				o.setPaymentType(rs.getString(9));
				list.add(o);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	
	public List<Bag_Order> getAllOrder() {
		
		 List<Bag_Order> list=new ArrayList<Bag_Order>();
		  Bag_Order o=null;
			try {
				
				String sql="select * from bag_order";
				PreparedStatement ps=conn.prepareStatement(sql); 
				ResultSet rs= ps.executeQuery();
				while(rs.next())
				{
					o=new Bag_Order();
					o.setId(rs.getInt(1));
					o.setOrderId(rs.getString(2));
					o.setUsername(rs.getString(3));
					o.setEmail(rs.getString(4));
					o.setFulladd(rs.getString(5));
					o.setPhno(rs.getString(6));
					o.setBagName(rs.getString(7));
					o.setPrice(rs.getString(8));
					o.setPaymentType(rs.getString(9));
					list.add(o);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}



	public List<Bag_Order> getBook(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
