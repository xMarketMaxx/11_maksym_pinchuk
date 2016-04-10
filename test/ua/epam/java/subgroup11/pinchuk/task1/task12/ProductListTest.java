package ua.epam.java.subgroup11.pinchuk.task1.task12;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.epam.java.subgroup11.pinchuk.task1.task11.Product;
import ua.epam.java.subgroup11.pinchuk.task1.task11.musicdepartment.guitar.AcousticGuitar;
import ua.epam.java.subgroup11.pinchuk.task1.task11.musicdepartment.guitar.ElectricGuitar;
import ua.epam.java.subgroup11.pinchuk.task1.task11.musicdepartment.keyboard.Synthesizer;

public class ProductListTest {

	private List<Product> list;

	private Product acousticGuitar;
	private Product electricGuitar;
	private Product synthesizer;
 
	@Before
	public void setUp() {
		list = new ProductList<Product>();

		acousticGuitar = new AcousticGuitar("Fender CD-60", 19000, "Yellow", 6, 643);
		electricGuitar = new ElectricGuitar("Cort X3 BK ", 18800, "Black", 6, "Standard Single-Coil Strat");
		synthesizer = new Synthesizer("Yamaha PSR-F50", 19200, 61, 109, 940, 306, "Black", false, true, 30);
	}

	private void addToList(Product... items) {
		for (Product p : items) {
			list.add(p);
		}
	}

	@Test
	public void testProductList() {
		List<Product> list = new ProductList<Product>();
		assertNotNull(list);
	}

	@Test
	public void testProductListCapacity() {
		List<Product> list = new ProductList<Product>(100);
		assertEquals(100, ((ProductList<Product>) list).capacity());
	}

	@Test
	public void testAdd() {
		addToList(acousticGuitar, electricGuitar, synthesizer);

		assertEquals(acousticGuitar, list.get(0));
		assertEquals(electricGuitar, list.get(1));
		assertEquals(synthesizer, list.get(2));
		assertEquals(3, list.size());
	}

	@Test
	public void testAddReallocMemory() {
		addToList(acousticGuitar, electricGuitar, null, new Synthesizer(), null, electricGuitar, acousticGuitar,
				electricGuitar, null, null, synthesizer);
		assertEquals(synthesizer, list.get(list.size() - 1));
	}

	@Test
	public void testAddByIndex() {
		addToList(acousticGuitar, electricGuitar);
		list.add(0, synthesizer);

		assertEquals(synthesizer, list.get(0));
	}

	@Test
	public void testAddByIndexInEmptyArray() {
		list.add(0, null);
		assertEquals(null, list.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddByIndexInEmptyArrayExceptionOutOfBounds() {
		list.add(2, null);
	}

	@Test
	public void testAddbyIndexWithoutReallocMemory() {
		addToList(acousticGuitar, electricGuitar, null, new Synthesizer(), null, electricGuitar, acousticGuitar,
				electricGuitar);
		list.add(7, null);
		assertEquals(null, list.get(7));
		assertEquals(electricGuitar, list.get(8));
		assertEquals(9, list.size());
	}

	@Test
	public void testAddByIndexWithReallocMemory() {
		addToList(acousticGuitar, electricGuitar, null, new Synthesizer(), null, electricGuitar, acousticGuitar,
				 null, null, electricGuitar);
		list.add(9, null);
		assertEquals(null, list.get(9));
		assertEquals(electricGuitar, list.get(10));
		assertEquals(11, list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddByIndexOutOfRangeLarger() {
		addToList(acousticGuitar, electricGuitar);
		list.add(4, synthesizer);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddByIndexOutOfRangeLess() {
		addToList(acousticGuitar, electricGuitar);
		list.add(-1, synthesizer);
	}

	@Test
	public void testClearCheck() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void testGet() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(acousticGuitar, list.get(0));
	}

	@Test
	public void testIndexOf() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(0, list.indexOf(acousticGuitar));
	}

	@Test
	public void testLastIndexOf() {
		addToList(acousticGuitar, electricGuitar, synthesizer, acousticGuitar);
		assertEquals(3, list.lastIndexOf(acousticGuitar));
	}

	@Test
	public void testLastIndexOfAtFirstPosition() {
		addToList(acousticGuitar, electricGuitar, synthesizer, null);
		assertEquals(0, list.lastIndexOf(acousticGuitar));
	}
	
	@Test
	public void testLastIndexOfNull() {
		addToList(acousticGuitar, null, electricGuitar, synthesizer,acousticGuitar,null);
		assertEquals(5, list.lastIndexOf(null));
	}

	@Test
	public void testLastIndexOfNullAtFirstPosition() {
		addToList(null,acousticGuitar,electricGuitar, synthesizer,  acousticGuitar);
		assertEquals(0, list.lastIndexOf(null));
	}
	
	@Test
	public void testContains() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(true, list.contains(acousticGuitar));
	}

	@Test
	public void testContainsFalse() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(false, list.contains(null));
	}

	@Test
	public void testIsEmptyTrue() {
		assertEquals(true, list.isEmpty());
	}

	@Test
	public void testIsEmptyFalse() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(false, list.isEmpty());
	}

	@Test
	public void testRemoveCheckSize() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		int listSize = list.size();
		list.remove(acousticGuitar);
		assertEquals(listSize - 1, list.size());
	}

	@Test
	public void testRemoveNotExistingElement() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(false, list.remove(new AcousticGuitar()));
	}

	@Test
	public void testRemoveCheckPopedElement() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		list.remove(0);
		assertEquals(electricGuitar, list.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfRange() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		list.remove(6);
	}

	@Test
	public void testRemoveNullElement() {
		addToList(null, electricGuitar, synthesizer);
		list.remove(null);
		assertEquals(2, list.size());
	}

	@Test
	public void testRemoveNullNotExistingElement() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(false, list.remove(null));
	}

	@Test
	public void testSet() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(acousticGuitar, list.set(0, electricGuitar));
		assertEquals(electricGuitar, list.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetOutOfRange() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(acousticGuitar, list.set(100, electricGuitar));
	}

	@Test
	public void toArray() {
		addToList(acousticGuitar, electricGuitar);

		assertEquals(acousticGuitar, list.toArray()[0]);
		assertEquals(electricGuitar, list.toArray()[1]);
	}

	@Test
	public void testSize() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		assertEquals(3, list.size());
	}

	@Test
	public void testToString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[{").append(acousticGuitar.toString()).append("} ]");
		sb.toString();
		addToList(acousticGuitar);
		assertEquals(sb.toString(), list.toString());
	}

	@Test
	public void testUnsupportedOperations() {
		int count = 0;
		try {
			list.containsAll(null);
		} catch (UnsupportedOperationException e) {
			count++;
		}
		try {
			list.toArray(null);
		} catch (UnsupportedOperationException e) {
			count++;
		}
		try {
			list.addAll(null);
		} catch (UnsupportedOperationException e) {
			count++;
		}
		try {
			list.addAll(1, null);
		} catch (UnsupportedOperationException e) {
			count++;
		}
		try {
			list.removeAll(null);
		} catch (UnsupportedOperationException e) {
			count++;
		}
		try {
			list.retainAll(null);
		} catch (UnsupportedOperationException e) {
			count++;
		}
		try {
			list.listIterator();
		} catch (UnsupportedOperationException e) {
			count++;
		}
		try {
			list.listIterator(1);
		} catch (UnsupportedOperationException e) {
			count++;
		}
		try {
			list.subList(1, 2);
		} catch (UnsupportedOperationException e) {
			count++;
		}
		assertEquals(9, count);
	}
}
