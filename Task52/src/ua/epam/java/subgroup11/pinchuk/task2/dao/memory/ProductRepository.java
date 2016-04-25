package ua.epam.java.subgroup11.pinchuk.task2.dao.memory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;

public class ProductRepository implements Serializable {

	private static final long serialVersionUID = -2847631679391815972L;
	public static final String REPOSITORY_IN_OUT_PATH = "D:\\eclipse_workspace\\Task4\\repository\\Rep.dat";

	private List<Product> storage;
	private static ProductRepository instance;

	private ProductRepository() {
		storage = new ArrayList<>();
		instance = this;
	}

	public static ProductRepository getInstance() {
		if (instance == null) {
			synchronized (ProductRepository.class) {
				if (instance == null) {
					instance = new ProductRepository();
				}
			}
		}
		return instance;
	}

	public void add(Product product) {
		storage.add(product);
	}

	public List<Product> getAll() {
		return storage;
	}

	public static ProductRepository readRepository() throws IOException {
		ProductRepository productRepository = new ProductRepository();
		FileInputStream fin = null;
		ObjectInputStream objectIn = null;
		try {
			fin = new FileInputStream(REPOSITORY_IN_OUT_PATH);
			objectIn = new ObjectInputStream(fin);
			productRepository = (ProductRepository) objectIn.readObject();
			ProductRepository.instance = productRepository;
			fin.close();
			objectIn.close();
		} catch (IOException e) {
			System.out.println(e);
			return productRepository;
		} catch (ClassNotFoundException c) {
			System.out.println("ProductRepository class not found! " + c);
			fin.close();
			objectIn.close();
			return productRepository;
		}
		System.out.println("Контейнер с товарами был прочитан!");
		return productRepository;
	}

	public static void saveRepository(ProductRepository repository) throws IOException {
		FileOutputStream fout = null;
		ObjectOutputStream objectOut = null;
		try {
			fout = new FileOutputStream(REPOSITORY_IN_OUT_PATH);
			objectOut = new ObjectOutputStream(fout);
			objectOut.writeObject(repository);
			fout.close();
			objectOut.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("Контейнер с товарами был сохранен!");
	}

	// вариант с товарами и их количеством "на складе"
	// private Map<Product, Integer> storage;
	//
	// public ProductRepository() {
	// storage = new HashMap<>();
	// }
	//
	// // for DEMO initialization
	// public void add(Product product, Integer quantity) {
	// storage.put(product, quantity);
	// }
	//
	// public Map<Product, Integer> getAll() {
	// return storage;
	// }
}
