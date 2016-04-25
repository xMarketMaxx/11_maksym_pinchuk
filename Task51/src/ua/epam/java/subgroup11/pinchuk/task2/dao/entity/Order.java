package ua.epam.java.subgroup11.pinchuk.task2.dao.entity;

import java.util.Date;

public class Order {

	private Date date;
	private ShoppingBag bag;

	public Order(){}
	
	public Order(Date date, ShoppingBag bag) {
		this.date = date;
		this.bag = bag;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ShoppingBag getBag() {
		return bag;
	}

	public void setBag(ShoppingBag bag) {
		this.bag = bag;
	}
	
}
