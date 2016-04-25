package ua.epam.java.subgroup11.pinchuk.task2.dao.memory;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.Order;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.ShoppingBag;

public class OrderRepository {

	private Map<Date, ShoppingBag> orders;

	public OrderRepository() {
		orders = new TreeMap<>();
	}

	public void add(Order order) {
		orders.put(order.getDate(), order.getBag());
	}

	public Map<Date, ShoppingBag> getAll() {
		return orders;
	}

}
