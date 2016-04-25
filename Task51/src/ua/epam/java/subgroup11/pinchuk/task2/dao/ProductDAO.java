package ua.epam.java.subgroup11.pinchuk.task2.dao;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;

public interface ProductDAO<T> extends DAO<T> {

	public Product getByIndex(int index);

}
