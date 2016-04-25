package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.util.List;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class AddToShoppingBugCommand extends Command {

	@Override
	public void execute(Service service, Inputter inputter) {
		printProductList(service.getProductsList());

		int productIndex = inputter.getInt("Введите индекс продукта: ");
		while (!indexRangeValidate(productIndex, service.getProductsList().size())) {
			System.out.println("Некорректный индекс, повторите!");
			productIndex = inputter.getInt("Введите индекс продукта: ");
		}

		int productQantity = inputter.getInt("Введите количество товаров: ");
		while (!quantityRangeValidate(productQantity)) {
			System.out.println("Некорректное количество товаров, повторите!");
			productQantity = inputter.getInt("Введите количество товаров: ");
		}

		service.addToShoppingBag(service.getProductByIndex(productIndex-1), productQantity);
		System.out.println("Товары добавлены!");
	}

	public void printProductList(List<Product> productList) {
		if (productList == null || productList.isEmpty()) {
			System.out.println("Список пуст!");
			return;
		}
		for (int i = 0, n = productList.size(); i < n; i++) {
			System.out.println(i + 1 + ") " + productList.get(i));
		}
	}

	private boolean indexRangeValidate(int small, int big) {
		return small <= big ? (small > 0 ? true : false) : false;
	}

	private boolean quantityRangeValidate(int quantity) {
		return quantity >= 0 ? true : false;
	}
}
