package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.ResourceBundle;

import ua.epam.java.subgroup11.pinchuk.task2.annotation.FieldAnno;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.guitar.AcousticGuitar;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.guitar.AcousticGuitarImpl;
import ua.epam.java.subgroup11.pinchuk.task2.proxy.AcousticGuitarProxy;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class AddAcousticGuitarCommand extends Command {

	private static final String RESOURCES_NAME = "resources";

	@Override
	public void execute(Service service, Inputter inputter) {

		Class<?> clazz = AcousticGuitarImpl.class;
		//
		// Object object = null;
		// try {
		// object = clazz.newInstance();
		// } catch (InstantiationException e) {
		// e.printStackTrace();
		// throw new RuntimeException(e);
		// } catch (IllegalAccessException e) {
		// e.printStackTrace();
		// throw new RuntimeException(e);
		// }

		AcousticGuitar object = (AcousticGuitar) AcousticGuitarProxy.newInstance(new AcousticGuitarImpl());

		// ResourceBundle rb = ResourceBundle.getBundle(RESOURCES_NAME, new
		// Locale("ru"));
		//
		// try {
		// for (Method method : clazz.getMethods()) {
		// if (method.isAnnotationPresent(FieldAnno.class)) {
		// for (Class<?> typeClass : method.getParameterTypes()) {
		// if (typeClass.equals(String.class)) {
		// method.invoke(object, inputter
		// .getString(rb.getString(method.getAnnotation(FieldAnno.class).fieldName())));
		// }
		// if (typeClass.equals(int.class)) {
		// method.invoke(object,
		// inputter.getInt(rb.getString(method.getAnnotation(FieldAnno.class).fieldName())));
		// }
		// if (typeClass.equals(boolean.class)) {
		// method.invoke(object, inputter
		// .getBoolean(rb.getString(method.getAnnotation(FieldAnno.class).fieldName())));
		// }
		// }
		// }
		// }
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		
		try {
			object.setColor(inputter.getString("Input acoustic guitar color"));
			object.setPrice(inputter.getInt("Input acoustic guitar price"));
			object.setSoundHoleSize(inputter.getInt("Input acoustic guitar soundhole size"));
			object.setStringsCount(inputter.getInt("Input acoustic guitar string count"));
			object.setTitle(inputter.getString("Input acoustic guitar title"));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println(object.toString());

		// service.addProductToStorage((Product) object);
		// System.out.println("New acoustic guitar was added");
	}

}
