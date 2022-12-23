package com.DAO;

import java.util.List;

import com.entity.Bag_Order;

public interface BagOrderDAO {


	boolean saveOrder(List<Bag_Order> blist);
	
	public List<Bag_Order> getBook(String email);
	
	public List<Bag_Order> getAllOrder();

	
	
}
