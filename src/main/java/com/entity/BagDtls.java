package com.entity;

public class BagDtls {
	private int bagId;
	private String bagName;
	private String price;
	private String bagCategory;
	private String status;
	private String photoName;
	private String email;
	 
	public BagDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BagDtls(String bagName, String price, String bagCategory, String status, String photoName,
			String email) {
		super();
		this.bagName = bagName;
		this.price = price;
		this.bagCategory = bagCategory;
		this.status = status;
		this.photoName = photoName;
		this.email = email;
	}
	public int getBagId() {
		return bagId;
	}
	public void setBagId(int bagId) {
		this.bagId = bagId;
	}
	public String getBagName() {
		return bagName;
	}
	public void setBagName(String bagName) {
		this.bagName = bagName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBagCategory() {
		return bagCategory;
	}
	public void setBagCategory(String bagCategory) {
		this.bagCategory = bagCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "bagDtls [bagId=" + bagId + ", bagName=" + bagName + ",price=" + price
				+ ", bagCategory=" + bagCategory + ", status=" + status + ", photoName=" + photoName + ", email="
				+ email + "]";
	}
	
	
	



	

}