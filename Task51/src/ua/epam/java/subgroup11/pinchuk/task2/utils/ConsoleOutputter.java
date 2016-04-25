package ua.epam.java.subgroup11.pinchuk.task2.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.Order;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;

public class ConsoleOutputter {
	// list area
	public static void printProductList(List<Product> productList) {
		if (productList == null || productList.isEmpty()) {
			System.out.println("Список пуст!");
			return;
		}
		for (int i = 0, n = productList.size(); i < n; i++) {
			System.out.println(i + 1 + ") " + productList.get(i));
		}
		System.out.println();
	}
	
	// map area
	public static void printMapContent(Map<Product, Integer> shoppingBag) {
		if (shoppingBag == null || shoppingBag.isEmpty()) {
			System.out.println("Пусто!");
			return;
		}
		Iterator<Map.Entry<Product, Integer>> it = shoppingBag.entrySet().iterator();
		Map.Entry<Product, Integer> entry = null;
		for (int i = 0; it.hasNext(); i++) {
			entry = it.next();
			System.out.println(i + 1 + ") " + entry.getKey() + ", quantity=" + entry.getValue());
		}
		System.out.println();
	}

	// order area
	public static void printOrder(Order order) {
		System.out.println("Дата заказа: " + order.getDate());
		System.out.println("Содержимое: ");
		printMapContent(order.getBag().getAll());
	}

}
