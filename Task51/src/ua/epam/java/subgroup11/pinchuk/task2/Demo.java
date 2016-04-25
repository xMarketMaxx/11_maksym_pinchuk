package ua.epam.java.subgroup11.pinchuk.task2;

import java.io.IOException;

import ua.epam.java.subgroup11.pinchuk.task2.command.CommandContainer;
import ua.epam.java.subgroup11.pinchuk.task2.dao.OrderDAO;
import ua.epam.java.subgroup11.pinchuk.task2.dao.ProductDAO;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.Order;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;
import ua.epam.java.subgroup11.pinchuk.task2.dao.impl.OrderDAOImpl;
import ua.epam.java.subgroup11.pinchuk.task2.dao.impl.ProductDAOImpl;
import ua.epam.java.subgroup11.pinchuk.task2.dao.memory.OrderRepository;
import ua.epam.java.subgroup11.pinchuk.task2.dao.memory.ProductRepository;
import ua.epam.java.subgroup11.pinchuk.task2.service.OrderService;
import ua.epam.java.subgroup11.pinchuk.task2.service.ProductService;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.service.ShoppingBagService;
import ua.epam.java.subgroup11.pinchuk.task2.utils.ConsoleInputter;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;
import ua.epam.java.subgroup11.pinchuk.task2.utils.RandomInputter;

public class Demo {

	private static Service service;
	private static Inputter utilInputter;
	private static String locale;

	public static void showMenu() {
		System.out.println("(Attention, write full command name!)");
		System.out.println("1.show product's list");
		System.out.println("2.add to shopping bag");
		System.out.println("3.show shopping bag");
		System.out.println("4.make order");
		System.out.println("5.show last added");
		System.out.println("6.show orders by period");
		System.out.println("7.show order by date");
		System.out.println("8.exit");
		System.out.println("---(manager block)---");
		System.out.println("9.add new acoustic guitar");
		System.out.println("10.add new annotated acoustic guitar");
		System.out.println("11.add new electic guitar");
		System.out.println("12.add new synthesizer");
	}

	public static Inputter initInputterType() {
		utilInputter = new ConsoleInputter();
		int chooseInputterType = 0;
		while (true) {
			chooseInputterType = utilInputter.getInt("Выберите режим ввода случайный/через консоль (0/1): ");
			if (chooseInputterType == 0) {
				System.out.println("Выбран режим случайного ввода!");
				return new RandomInputter();
			} else if (chooseInputterType == 1) {
				System.out.println("Выбран режим консольного ввода!");
				return new ConsoleInputter();
			}
		}
	}

	public static String initLocale() {
		String locale = "";
		while (true) {
			locale = utilInputter.getString("Выбирете локаль (ru/en): ");
			if (locale.equals("ru") || locale.equals("en")) {
				System.out.println("Выбранная локаль: " + locale);
				return locale;
			} else {
				System.out.println("Некоррекный ввод, повторите!");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Inputter inputter = initInputterType();
		locale = initLocale();
		initDependency();

		while (true) {
			showMenu();
			CommandContainer.getCommand(utilInputter.getString("Введите команду: ")).execute(service, inputter);
		}

	}

	public static void initDependency() throws IOException {

		ProductRepository productRepository = ProductRepository.readRepository();
		OrderRepository orderRepository = new OrderRepository();

		// DAO init
		OrderDAO<Order> orderDAO = new OrderDAOImpl(orderRepository);
		ProductDAO<Product> productDAO = new ProductDAOImpl(productRepository);

		// service init
		OrderService orderService = new OrderService(orderDAO);
		ProductService productService = new ProductService(productDAO);
		ShoppingBagService shoppingBagService = new ShoppingBagService();

		service = new Service();
		service.setOrderService(orderService);
		service.setProductService(productService);
		service.setShoppingBagService(shoppingBagService);

		// ComandContainer init
		CommandContainer.init();
	}

	public static String getLocale() {
		return locale;
	}
}
