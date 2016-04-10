package ua.epam.java.subgroup11.pinchuk.task1.task12;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ua.epam.java.subgroup11.pinchuk.task1.task11.Product;
import ua.epam.java.subgroup11.pinchuk.task1.task12.iterator.PredicateProductIterator;

public class ProductList<T extends Product> implements List<T> {

	private Product[] array;
	private int lastElementIndex;

	public ProductList() {
		array = null;
		lastElementIndex = -1;
	}

	public ProductList(int capacity) {
		array = new Product[capacity];
		lastElementIndex = -1;
	}

	private void indexOutOfRange(int index) {
		if (index != 0) {
			if (index < 0 || index > lastElementIndex) {
				throw new IndexOutOfBoundsException(
						"Index must be in range:" + "0 <= " + index + " <= " + lastElementIndex);
			}
		}
	}

	@Override
	public boolean add(T e) {
		if (array == null) {
			array = new Product[10];
			array[++lastElementIndex] = e;
		} else if (lastElementIndex < array.length - 1) {
			array[++lastElementIndex] = e;
		} else {
			Product[] copy = new Product[array.length + array.length / 3 + 1];
			System.arraycopy(array, 0, copy, 0, array.length);
			copy[++lastElementIndex] = e;
			array = copy;
		}
		return true;
	}

	@Override
	public void add(int index, T e) {
		indexOutOfRange(index);
		if (array == null) {
			array = new Product[10];
			array[++lastElementIndex] = e;
			return;
		}
		// if we have enough memory in array to add one new element
		else if (lastElementIndex < array.length - 1) {
			Product[] copy = new Product[lastElementIndex - index + 1];
			System.arraycopy(array, index, copy, 0, copy.length);
			array[index] = e;
			System.arraycopy(copy, 0, array, index + 1, copy.length);
			++lastElementIndex;
		} else {
			Product[] copy = new Product[array.length + array.length / 3 + 1];
			System.arraycopy(array, 0, copy, 0, index - 1);
			copy[index] = e;
			System.arraycopy(array, index, copy, index + 1, array.length - index);
			array = copy;
			++lastElementIndex;
		}
	}

	@Override
	public void clear() {
		array = null;
		lastElementIndex = -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		indexOutOfRange(index);
		return (T) array[index];
	}

	private int indexOfNullElement(Object o, boolean order) {
		if (order) {
			for (int i = 0; i <= lastElementIndex; i++) {
				if (array[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = lastElementIndex; i > -1; i--) {
				if (array[i] == null) {
					return i;
				}
			}
		}
		return -1;
	}

	private int indexOfNotNullElement(Object o, boolean order) {
		if (order) {
			for (int i = 0; i <= lastElementIndex; i++) {
				if (o.equals(array[i])) {
					return i;
				}
			}
		} else {
			for (int i = lastElementIndex; i > -1; i--) {
				if (o.equals(array[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	// find index of the element
	// order==true ==> from 0 to last
	// order==false ==> from last to 0
	private int indexOf(Object o, boolean order) {
		return o == null ? indexOfNullElement(o, order) : indexOfNotNullElement(o, order);
	}

	@Override
	public int indexOf(Object o) {
		return indexOf(o, true);
	}

	@Override
	public int lastIndexOf(Object o) {
		return indexOf(o, false);
	}

	@Override
	public boolean contains(Object arg0) {
		return indexOf(arg0) != -1 ? true : false;
	}

	@Override
	public boolean isEmpty() {
		return lastElementIndex == -1;
	}

	// shift element in array from right to left
	// index element will be overwrite by next
	private boolean shiftLeft(int index) {
		for (int i = index; i < lastElementIndex; i++) {
			array[i] = array[i + 1];
		}
		--lastElementIndex;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (o == null) {
			int index = indexOfNullElement(o, true);
			return index != -1 ? shiftLeft(index) : false;
		} else {
			int index = indexOfNotNullElement(o, true);
			return index != -1 ? shiftLeft(index) : false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		indexOutOfRange(index);
		T oldProductItem = null;
		for (int i = 0; i <= lastElementIndex; i++) {
			if (i == index) {
				oldProductItem = (T) array[i];
				for (int j = i; j < lastElementIndex; j++) {
					array[j] = array[j + 1];
				}
			}
		}
		--lastElementIndex;
		return oldProductItem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T set(int index, T element) {
		indexOutOfRange(index);
		T oldProductItem = (T) array[index];
		array[index] = element;
		return oldProductItem;
	}

	@Override
	public Object[] toArray() {
		Product[] copy = new Product[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);
		return copy;
	}

	@Override
	public int size() {
		return lastElementIndex == -1 ? 0 : (lastElementIndex + 1);
	}

	public int capacity() {
		return array.length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i <= lastElementIndex; i++) {
			sb.append("{").append(array[i].toString()).append("} ");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		PredicateProductIterator iterator = new PredicateProductIterator(p -> p.getPrice() >= 0);
		iterator.setMyList((List<Product>) (this));
		return (Iterator<T>) iterator;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

}
