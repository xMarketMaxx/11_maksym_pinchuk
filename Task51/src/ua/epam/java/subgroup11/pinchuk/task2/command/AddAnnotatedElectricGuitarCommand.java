package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.ResourceBundle;

import ua.epam.java.subgroup11.pinchuk.task2.Demo;
import ua.epam.java.subgroup11.pinchuk.task2.annotation.GetSetField;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.guitar.AcousticGuitar;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class AddAnnotatedElectricGuitarCommand extends Command{

	private static final String RESOURCES_NAME = "resources";

	@Override
	public void execute(Service service, Inputter inputter) {

		Class<?> clazz = AcousticGuitar.class;

		Object object = null;
		try {
			object = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		ResourceBundle rb = ResourceBundle.getBundle(RESOURCES_NAME, new Locale(Demo.getLocale()));

		try {
			for (Method method : clazz.getMethods()) {
				if (method.isAnnotationPresent(GetSetField.class)) {
					for (Class<?> typeClass : method.getParameterTypes()) {
						if (typeClass.equals(String.class)) {
							method.invoke(object, inputter
									.getString(rb.getString(method.getAnnotation(GetSetField.class).fieldName())));
						}
						if (typeClass.equals(int.class)) {
							method.invoke(object,
									inputter.getInt(rb.getString(method.getAnnotation(GetSetField.class).fieldName())));
						}
						if (typeClass.equals(boolean.class)) {
							method.invoke(object, inputter
									.getBoolean(rb.getString(method.getAnnotation(GetSetField.class).fieldName())));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(object.toString());

		service.addProductToStorage((Product) object);
		System.out.println("Новая акустическая гитара добавлена!");
	}

}
