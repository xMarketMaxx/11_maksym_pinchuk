package ua.epam.java.subgroup11.pinchuk.task2.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.Order;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.ShoppingBag;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;

public class Service {

	private ProductService productService;
	private OrderService orderService;
	private ShoppingBagService shoppingBagService;

	// products area
	public List<Product> getProductsList() {
		return productService.getAll();
	}

	public Product getProductByIndex(int index) {
		return productService.getByIndex(index);
	}
	
	public void addProductToStorage(Product product){
		productService.add(product);
	}
	
	// shopping bag area
	public ShoppingBag getShoppingBag() {
		return shoppingBagService.get();
	}

	public void addToShoppingBag(Product product, int quantity) {
		shoppingBagService.add(product, quantity);
	}

	public Map<Product, Integer> getShoppingBagContent() {
		return shoppingBagService.getAllProduct();
	}

	public Map<Product, Integer> getLastAddedProducts() {
		return shoppingBagService.getLastAddedProducts();
	}

	public int getShoppingBagTotalCost() {
		return shoppingBagService.getTotalCost();
	}

	// order area
	public void addOrder(Date date, ShoppingBag bag) {
		orderService.add(date, bag);
		shoppingBagService.resetShoppingBag();
	}

	public List<Order> getOrdersByDatesRange(Date from, Date to) {
		return orderService.getByDateRange(from, to);
	}

	public Order getNearestOrderByDate(Date date) {
		return orderService.getNearestByDate(date);
	}

	public Order createEmptyOrder() {
		return orderService.createEmptyOrder();
	}

	// set services area
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setShoppingBagService(ShoppingBagService shoppingBagService) {
		this.shoppingBagService = shoppingBagService;
	}
}
