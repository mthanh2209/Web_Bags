package com.DAO;

import java.util.ArrayList;
import java.util.List;

import com.entity.BagDtls;

public interface BagDAO {
    public boolean addBags(BagDtls b);
     
    public List<BagDtls> getAllBags();
    
    public BagDtls getBagById(int id);
    
    public boolean updateEditBags(BagDtls b);
    
    public boolean deleteBags(int id);
    
    public List<BagDtls> getNewBag();
		
    public List<BagDtls> getFeaturedBags();
    
    public List<BagDtls> getOldBags();
    
    public List<BagDtls> getAllFeaturedBag();
    
    public List<BagDtls> getAllNewBag();
    
    public List<BagDtls> getAllOldBag();
    
    public List<BagDtls> getBagByOld(String email,String cate);
    
    public boolean oldBagDelete(String email,String cat,int id);
  
    public List<BagDtls> getBagBySearch(String ch);
   
	}
    
    

