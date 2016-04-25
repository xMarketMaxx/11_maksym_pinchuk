package ua.epam.java.subgroup11.pinchuk.task2.service;

import java.util.List;

import ua.epam.java.subgroup11.pinchuk.task2.dao.ProductDAO;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;

public class ProductService {

	private ProductDAO<Product> productDAO;

	public ProductService(ProductDAO<Product> productDAO) {
		this.productDAO = productDAO;
	}

	/**
	 * Add new product to ProductRepository
	 */
	public void add(Product product) {
		productDAO.add(product);
	}

	/**
	 * Returns all products available in DB
	 */
	public List<Product> getAll() {
		return productDAO.getAll();
	}

	/**
	 * Returns Product by index from DB.
	 */
	public Product getByIndex(int index) {
		return productDAO.getByIndex(index);
	}

}
