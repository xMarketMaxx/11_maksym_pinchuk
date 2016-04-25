package ua.epam.java.subgroup11.pinchuk.task2.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.ShoppingBag;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;

public class ShoppingBagService {

	public static final int LAST_ADDED_PRODUCTS_MAP_SIZE = 5;

	private ShoppingBag bag;
	private LinkedHashMap<Product, Integer> lastAddedProductsMap;

	public ShoppingBagService() {
		bag = new ShoppingBag();
		lastAddedProductsMap = new LinkedHashMap<>();
	}

	public void add(Product product, Integer quantity) {
		bag.add(product, quantity);
		updateLastAddedProductsMap(product, quantity);
	}

	public ShoppingBag get() {
		return bag;
	}

	public Map<Product, Integer> getAllProduct() {
		return bag.getAll();
	}

	public Map<Product, Integer> getLastAddedProducts() {
		return lastAddedProductsMap;
	}

	public void resetShoppingBag() {
		bag = new ShoppingBag();
	}

	public int getTotalCost() {
		int shoppingBagTotalCost = 0;
		for (Map.Entry<Product, Integer> p : bag.getAll().entrySet()) {
			shoppingBagTotalCost += p.getValue() * p.getKey().getPrice();
		}
		return shoppingBagTotalCost;
	}

	private void updateLastAddedProductsMap(Product product, Integer quantity) {
		if (lastAddedProductsMap.size() < LAST_ADDED_PRODUCTS_MAP_SIZE) {
			lastAddedProductsMap.put(product, quantity);
		} else {
			if (lastAddedProductsMap.containsKey(product)) {
				lastAddedProductsMap.remove(product);
			}
			Iterator<Entry<Product, Integer>> it = lastAddedProductsMap.entrySet().iterator();
			it.next();
			it.remove();
			lastAddedProductsMap.put(product, quantity);
		}
	}
}
