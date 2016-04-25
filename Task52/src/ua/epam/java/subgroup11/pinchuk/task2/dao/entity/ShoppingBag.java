package ua.epam.java.subgroup11.pinchuk.task2.dao.entity;

import java.util.HashMap;
import java.util.Map;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;

// ShoppingBagService contain an object of this class
public class ShoppingBag {

	private Map<Product, Integer> bag;
	
	public ShoppingBag() {
		bag = new HashMap<>();
	}
	
	public void add(Product product, Integer quantity) {
		bag.put(product, quantity);
	}
	
	public Map<Product, Integer> getAll() {
		return bag;
	}
}
