package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class MakeOrderCommand extends Command {

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

	@Override
	public void execute(Service service, Inputter inputter) {
		System.out.println("Вы собираетесь сделать заказ на текущую корзину.");
		printShoppingBagContent(service.getShoppingBagContent());

		System.out.println("Общая стоимость: " + service.getShoppingBagTotalCost()/100 + "." + service.getShoppingBagTotalCost()%100 );
		System.out.println();
		boolean confirmOrder = inputter.getBoolean("Подтвердите заказ (true/false): ");
		if (!confirmOrder) {
			return;
		}

		Date orderDate = getDate(inputter);
		service.addOrder(orderDate, service.getShoppingBag());
		System.out.println("Заказ добавлен!");
	}

	private Date getDate(Inputter inputter) {
		do {
			String stringDate = inputter.getString("Введите дату заказа (yyyy-MM-dd HH:mm): ");
			try {
				return new Date(simpleDateFormat.parse(stringDate).getTime());
			} catch (ParseException e) {
			}
			System.out.print("Некорректный ввод!");
		} while (true);
	}

	private void printShoppingBagContent(Map<Product, Integer> shoppingBag) {
		if (shoppingBag == null || shoppingBag.isEmpty()) {
			System.out.println("Корзина пустая!");
			return;
		}
		Iterator<Map.Entry<Product, Integer>> it = shoppingBag.entrySet().iterator();
		Map.Entry<Product, Integer> entry = null;
		for (int i = 0; it.hasNext(); i++) {
			entry = it.next();
			System.out.println(i + 1 + ") " + entry.getKey() + ", quantity=" + entry.getValue());
		}
	}

}
