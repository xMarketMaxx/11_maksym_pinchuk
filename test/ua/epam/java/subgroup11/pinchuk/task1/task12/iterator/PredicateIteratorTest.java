package ua.epam.java.subgroup11.pinchuk.task1.task12.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import ua.epam.java.subgroup11.pinchuk.task1.task11.Product;
import ua.epam.java.subgroup11.pinchuk.task1.task11.musicdepartment.guitar.AcousticGuitar;
import ua.epam.java.subgroup11.pinchuk.task1.task11.musicdepartment.guitar.ElectricGuitar;
import ua.epam.java.subgroup11.pinchuk.task1.task11.musicdepartment.keyboard.Synthesizer;
import ua.epam.java.subgroup11.pinchuk.task1.task12.ProductList;

public class PredicateIteratorTest {

	private List<Product> list;
	private Product acousticGuitar;
	private Product electricGuitar;
	private Product synthesizer;

	@Before
	public void SetUp() {
		list = new ProductList<>();

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
	public void testIterator() {
		addToList(acousticGuitar, electricGuitar, synthesizer);

		Iterator<Product> it = list.iterator();
		assertEquals(acousticGuitar, it.next());
		assertEquals(electricGuitar, it.next());
		assertEquals(synthesizer, it.next());
	}

	@Test
	public void testPredicateProductIterator() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		PredicateProductIterator it = (PredicateProductIterator) list.iterator();
		it.setPredicate(p -> p.getPrice() > 18900);

		assertEquals(acousticGuitar, it.next());
		assertEquals(synthesizer, it.next());
	}

	@Test
	public void testHasNext() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		PredicateProductIterator it = (PredicateProductIterator) list.iterator();
		it.setPredicate(p -> p.getPrice() > 18900);

		int count = 0;
		while (it.hasNext()) {
			it.next();
			count++;
		}
		assertEquals(2, count);
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextException() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		PredicateProductIterator it = (PredicateProductIterator) list.iterator();
		it.setPredicate(p -> p.getPrice() > 18900);
		for (int i = 0; i < 3; i++) {
			it.next();
		}
	}

	@Test
	public void testRemove() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		PredicateProductIterator it = (PredicateProductIterator) list.iterator();
		it.setPredicate(p -> p.getPrice() > 18900);

		it.next();
		it.remove();

		assertEquals(synthesizer, it.next());
		assertEquals(electricGuitar, list.get(0));
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveException() {
		addToList(acousticGuitar, electricGuitar, synthesizer);
		PredicateProductIterator it = (PredicateProductIterator) list.iterator();
		it.setPredicate(p -> p.getPrice() > 18900);

		it.next();
		it.remove();
		it.remove();
	}

}
