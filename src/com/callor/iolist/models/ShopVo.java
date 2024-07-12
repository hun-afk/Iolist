package com.callor.iolist.models;

public class ShopVo {
	
	public String date;
	public int time;
	public int trans;
	public String product;
	public int quantity;
	public int price;
	
	public int purchase;
	public int sales;
	
	@Override
	public String toString() {
		return "ShopVo [date=" + date + ", time =" + time + ", trans =" + trans + ", product =" + product
				+ ", quantity =" + quantity + ", price =" + price + ", purchase =\" + purchase "
						+ "+ \", sales =\" + sales + \"]";
	}
}