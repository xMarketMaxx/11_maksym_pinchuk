package ua.epam.java.subgroup11.pinchuk.task2.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ua.epam.java.subgroup11.pinchuk.task2.dao.OrderDAO;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.Order;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.ShoppingBag;
import ua.epam.java.subgroup11.pinchuk.task2.dao.memory.OrderRepository;

public class OrderDAOImpl<T> implements OrderDAO<T> {

	private OrderRepository orders;

	public OrderDAOImpl(OrderRepository orderRepository) {
		this.orders = orderRepository;
	}

	@Override
	public List<T> getAll() {
		List<T> orderList = new ArrayList<>();
		for (Map.Entry<Date, ShoppingBag> e : orders.getAll().entrySet()) {
			orderList.add((T) new Order(e.getKey(), e.getValue()));
		}
		return orderList;
	}

	@Override
	public void add(T t) {
		orders.add((Order) t);
	}
}
