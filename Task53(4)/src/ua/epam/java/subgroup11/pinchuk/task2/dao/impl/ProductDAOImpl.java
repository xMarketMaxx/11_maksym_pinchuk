package ua.epam.java.subgroup11.pinchuk.task2.dao.impl;

import java.util.List;

import ua.epam.java.subgroup11.pinchuk.task2.dao.ProductDAO;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;
import ua.epam.java.subgroup11.pinchuk.task2.dao.memory.ProductRepository;

public class ProductDAOImpl<T> implements ProductDAO<T> {

	private ProductRepository storage;

	public ProductDAOImpl(ProductRepository storage) {
		this.storage = storage;
	}

	@Override
	public List<T> getAll() {
		return (List<T>) storage.getAll();
	}

	@Override
	public void add(T t) {
		storage.add((Product) t);
	}

	@Override
	public Product getByIndex(int index) {
		return storage.getAll().get(index);
	}

	// вариант с товарами и их количеством "на складе"
	// @Override
	// public List<T> getAll() {
	// List<T> productList = new ArrayList<>();
	// for (Map.Entry<Product, Integer> e : storage.getAll().entrySet()) {
	// productList.add((T) e.getKey());
	// }
	// return productList;
	// }
	//
	// // заполняем только из Demo
	// @Override
	// public void add(T t) {
	// throw new UnsupportedOperationException();
	// }

}
