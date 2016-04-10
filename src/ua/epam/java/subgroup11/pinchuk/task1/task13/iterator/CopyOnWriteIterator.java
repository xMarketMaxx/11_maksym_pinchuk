package ua.epam.java.subgroup11.pinchuk.task1.task13.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import ua.epam.java.subgroup11.pinchuk.task1.task11.Product;

public class CopyOnWriteIterator<T extends Object> implements Iterator<T> {

	private final Object[] list;
	private int currentIndex;

	public CopyOnWriteIterator(List<Product> list, int startIndex) {
		this.list = list.toArray();
		currentIndex = startIndex;
	}

	@Override
	public synchronized boolean hasNext() {
		return currentIndex >= 0 ? (currentIndex < list.length ? true : false) : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized T next() {
		if (hasNext()) {
			return (T) list[currentIndex++];
		}
		throw new NoSuchElementException();
	}

	@Override
	public synchronized void remove() {
		throw new UnsupportedOperationException();
	}

}
