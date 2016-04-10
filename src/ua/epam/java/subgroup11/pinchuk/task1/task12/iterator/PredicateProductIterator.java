package ua.epam.java.subgroup11.pinchuk.task1.task12.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import ua.epam.java.subgroup11.pinchuk.task1.task11.Product;

public class PredicateProductIterator implements Iterator<Product> {

	private Predicate<Product> predicate;
	private List<Product> list;
	private Product pushedElement;
	private int currentIndex;
	private boolean canRemove;
	private boolean hasPushedElement;

	public PredicateProductIterator(Predicate<Product> predicate) {
		this.predicate = predicate;
	}

	private void reset() {
		currentIndex = 0;
		canRemove = false;
		hasPushedElement = false;
	}

	public void setMyList(List<Product> myList) {
		reset();
		this.list = myList;
	}

	public void setPredicate(Predicate<Product> predicate) {
		reset();
		this.predicate = predicate;
	}

	private boolean commonHasNext() {
		return currentIndex >= 0 ? (currentIndex < list.size() ? true : false) : false;
	}

	private boolean findNextElement() {
		boolean isFound = false;
		while (!isFound && commonHasNext()) {
			if (predicate.test(list.get(currentIndex))) {
				pushedElement = list.get(currentIndex);
				hasPushedElement = true;
				currentIndex++;
				isFound = true;
				break;
			}
			currentIndex++;
		}
		return isFound;
	}

	@Override
	public boolean hasNext() {
		if (hasPushedElement) {
			return true;
		} else {
			return findNextElement();
		}
	}

	@Override
	public Product next() {
		if(hasNext()) {
			{
				canRemove = true;
				hasPushedElement = false;
				return pushedElement;
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public void remove() {
		if (canRemove) {
			list.remove(pushedElement);
			hasPushedElement = false;
			canRemove = false;
		} else {
			throw new IllegalStateException();
		}
	}
}