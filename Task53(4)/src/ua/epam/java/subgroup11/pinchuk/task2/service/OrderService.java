package ua.epam.java.subgroup11.pinchuk.task2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.epam.java.subgroup11.pinchuk.task2.dao.OrderDAO;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.Order;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.ShoppingBag;

public class OrderService {

	private OrderDAO<Order> orderDAO;

	public OrderService(OrderDAO<Order> orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	/**
	 * Create an empty order
	 * */
	public Order createEmptyOrder(){
		return new Order();
	}
	/**
	 * Add new order with date and bag parameters
	 */
	public void add(Date date, ShoppingBag bag) {
		Order newOrder = new Order(date, bag);
		orderDAO.add(newOrder);
	}

	/**
	 * Find orders by range. Inclusive "from" and "to" dates
	 */
	public List<Order> getByDateRange(Date from, Date to) {
		List<Order> result = new ArrayList<Order>();

		for (Order o : orderDAO.getAll()) {
			if ((o.getDate().compareTo(from) >= 0) && (o.getDate().compareTo(to) <= 0)) {
				result.add(o);
			}
		}
		return result;
	}

	/**
	 * Find nearest order to this date
	 */
	public Order getNearestByDate(Date date) {
		long minDifference = Long.MAX_VALUE;
		long currentDifference = 0;
		Order nearestOrder = null;

		for (Order o : orderDAO.getAll()) {
			currentDifference = o.getDate().getTime() - date.getTime();
			currentDifference = Math.abs(currentDifference);
			if (currentDifference < minDifference) {
				minDifference = currentDifference;
				nearestOrder = o;
			}
		}

		return nearestOrder;
	}

}
