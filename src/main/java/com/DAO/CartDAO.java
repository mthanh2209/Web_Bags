package com.DAO;

import java.util.List;

import com.entity.BagDtls;
import com.entity.Cart;

public interface CartDAO {
   public boolean addCart(Cart c);
   
   public List<Cart> getBagByUser(int userId);
   
   public boolean deleteBag(int bid,int uid, int cid);
   
}
