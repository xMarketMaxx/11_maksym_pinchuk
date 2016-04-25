package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.util.Iterator;
import java.util.Map;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class ShowLastAddedCommand extends Command {

	@Override
	public void execute(Service service, Inputter inputter) {
		System.out.println("Последние добавленные товары:");
		printMapContent(service.getLastAddedProducts());
	}

	public void printMapContent(Map<Product, Integer> map) {
		if (map == null || map.isEmpty()) {
			System.out.println("Корзина пустая!");
			return;
		}
		Iterator<Map.Entry<Product, Integer>> it = map.entrySet().iterator();
		Map.Entry<Product, Integer> entry = null;
		for (int i = 0; it.hasNext(); i++) {
			entry = it.next();
			System.out.println(i + 1 + ") " + entry.getKey() + "; quantity=" + entry.getValue());
		}

	}
}
