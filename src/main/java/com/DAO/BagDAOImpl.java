package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BagDtls;

public class BagDAOImpl implements BagDAO {

	private Connection conn;

	public BagDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addBags(BagDtls b) {
		boolean f = false;
		try {
			
			String sql = "INSERT INTO bag_dtls (bagName,price,bagCategory,status,photo,email) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBagName());
			ps.setString(2, b.getPrice());
			ps.setString(3, b.getBagCategory());
			ps.setString(4, b.getStatus());
			ps.setString(5, b.getPhotoName());
			ps.setString(6, b.getEmail());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public List<BagDtls> getAllBags() {
		List<BagDtls> list = new ArrayList<BagDtls>();
		BagDtls b = null;
		try {
			String sql = "select *from bag_dtls";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public BagDtls getBagById(int id) {
		BagDtls b = null;

		try {

			String sql = "SELECT * FROM bag_dtls where bagId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	
	public boolean updateEditBags(BagDtls b) {
		boolean f = false;
		try {
			String sql = "update bag_dtls set bagName=?,price=?,status=? where bagId=? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, b.getBagName());
			ps.setString(2, b.getPrice());
			ps.setString(3, b.getStatus());
			ps.setInt(4, b.getBagId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public boolean deleteBags(int id) {
		boolean f = false;

		try {
			String sql = "delete from bag_dtls where bagId=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public List<BagDtls> getNewBag() {
		List<BagDtls> list = new ArrayList<BagDtls>();
		BagDtls b = new BagDtls();
		try {
			String sql = "select * from bag_dtls  where bagCategory=? and status=? order by bagId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				list.add(b);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public List<BagDtls> getFeaturedBags() {
		List<BagDtls> list = new ArrayList<BagDtls>();
		BagDtls b = new BagDtls();
		try {
			String sql = "select * from bag_dtls  where status=? order by bagId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				list.add(b);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public List<BagDtls> getOldBags() {
		List<BagDtls> list = new ArrayList<BagDtls>();
		BagDtls b = new BagDtls();
		try {
			String sql = "select * from bag_dtls  where bagCategory=? and status=? order by bagId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				list.add(b);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<BagDtls> getAllFeaturedBag() {
		List<BagDtls> list = new ArrayList<BagDtls>();
		BagDtls b = new BagDtls();
		try {
			String sql = "select * from bag_dtls  where status=? order by bagId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<BagDtls> getAllNewBag() {
		List<BagDtls> list = new ArrayList<BagDtls>();
		BagDtls b = new BagDtls();
		try {
			String sql = "select * from bag_dtls  where bagCategory=? and status=? order by bagId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<BagDtls> getAllOldBag() {
		List<BagDtls> list = new ArrayList<BagDtls>();
		BagDtls b = new BagDtls();
		try {
			String sql = "select * from bag_dtls  where bagCategory=? and status=? order by bagId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public List<BagDtls> getBagByOld(String email, String cate) {
		{
			List<BagDtls> list = new ArrayList<BagDtls>();
			BagDtls b = null;
			try {
				String sql = "select * from bag_dtls where bagCategory=? and email=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cate);
				ps.setString(2, email);

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					b = new BagDtls();
					b.setBagId(rs.getInt(1));
					b.setBagName(rs.getString(2));
					b.setPrice(rs.getString(3));
					b.setBagCategory(rs.getString(4));
					b.setStatus(rs.getString(5));
					b.setPhotoName(rs.getString(6));
					b.setEmail(rs.getString(7));
					list.add(b);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	}

	
	public boolean oldBagDelete(String email, String cat,int id) {
		boolean f = false;
		try {
			String sql = "delete from bag_dtls where bagCategory=? and email=? and bagId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cat);
			ps.setString(2, email);
            ps.setInt(3, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public List<BagDtls> getBagBySearch(String ch) {
		
		List<BagDtls> list = new ArrayList<BagDtls>();
		BagDtls b = null;
		try {
			String sql = "select * from bag_dtls where bagName like ? or  bagCategory like ? and status=? " ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BagDtls();
				b.setBagId(rs.getInt(1));
				b.setBagName(rs.getString(2));
				b.setPrice(rs.getString(3));
				b.setBagCategory(rs.getString(4));
				b.setStatus(rs.getString(5));
				b.setPhotoName(rs.getString(6));
				b.setEmail(rs.getString(7));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	
}
