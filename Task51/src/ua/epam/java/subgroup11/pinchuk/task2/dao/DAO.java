package ua.epam.java.subgroup11.pinchuk.task2.dao;

import java.util.List;

public interface DAO<T> {

	public List<T> getAll();

	public void add(T t);
}
