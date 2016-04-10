package ua.epam.java.subgroup11.pinchuk.task1.task14.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ua.epam.java.subgroup11.pinchuk.task1.task11.Product;

public class FlexibleList<T extends Product> extends ArrayList<T> {

	private static final long serialVersionUID = 4666790188835221603L;

	private List<T> uList;
	private List<T> mList;

	public FlexibleList(List<T> unmodifiableList, List<T> modifiableList) {
		if (modifiableList == null) {
			throw new NullPointerException();
		}
		this.mList = modifiableList;
		this.uList = new InnerUnmodifiableList<T>(unmodifiableList);
	}

	public List<T> getModifiableList() {
		return mList;
	}

	public List<T> getUnmodifiableList() {
		return uList;
	}
	
	// read-only wrapper
	private class InnerUnmodifiableList<T extends Product> implements List<T> {

		private List<T> unmodifiableList;

		public InnerUnmodifiableList(List<T> list) {
			if (list == null) {
				throw new NullPointerException();
			}
			unmodifiableList = list;
		}

		@Override
		public Iterator<T> iterator() {
			return new Iterator<T>() {
				private Iterator<T> it = unmodifiableList.iterator();

				@Override
				public boolean hasNext() {
					return it.hasNext();
				}

				@Override
				public T next() {
					return it.next();
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}

		@Override
		public T get(int index) {
			return (T) unmodifiableList.get(index);
		}

		@Override
		public int indexOf(Object o) {
			return unmodifiableList.indexOf(o);
		}

		@Override
		public int lastIndexOf(Object o) {
			return unmodifiableList.indexOf(o);
		}

		@Override
		public List<T> subList(int startIndex, int endIndex) {
			return new InnerUnmodifiableList<T>(unmodifiableList.subList(startIndex, endIndex));
		}

		@Override
		public int size() {
			return unmodifiableList.size();
		}

		@Override
		public boolean isEmpty() {
			return unmodifiableList.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return unmodifiableList.contains(o);
		}

		@Override
		public Object[] toArray() {
			return unmodifiableList.toArray();
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return unmodifiableList.containsAll(c);
		}

		@Override
		public <E> E[] toArray(E[] a) {
			return unmodifiableList.toArray(a);
		}

		public boolean add(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean remove(Object o) {
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
		public void clear() {
			throw new UnsupportedOperationException();
		}

		@Override
		public T set(int index, Product element) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(int index, Product element) {
			throw new UnsupportedOperationException();
		}

		@Override
		public T remove(int index) {
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
		public boolean addAll(Collection<? extends T> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(int index, Collection<? extends T> c) {
			throw new UnsupportedOperationException();
		}
	}

}
