package ua.epam.java.subgroup11.pinchuk.task2.dao.impl;

import java.util.List;

import ua.epam.java.subgroup11.pinchuk.task2.dao.ProductDAO;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;
import ua.epam.java.subgroup11.pinchuk.task2.dao.memory.ProductRepository;

public class ProductDAOImpl implements ProductDAO<Product> {

	private ProductRepository storage;

	public ProductDAOImpl(ProductRepository storage) {
		this.storage = storage;
	}

	@Override
	public List<Product> getAll() {
		return (List<Product>) storage.getAll();
	}

	@Override
	public void add(Product product) {
		storage.add(product);
	}

	@Override
	public Product getByIndex(int index) {
		return storage.getAll().get(index);
	}
}
