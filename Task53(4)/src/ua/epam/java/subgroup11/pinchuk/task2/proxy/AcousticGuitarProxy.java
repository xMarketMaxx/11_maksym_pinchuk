package ua.epam.java.subgroup11.pinchuk.task2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.AccessException;
import java.util.HashMap;
import java.util.Map;

public class AcousticGuitarProxy implements InvocationHandler {

	Object object;
	Map<String, Object> fieldsMap;

	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new AcousticGuitarProxy(obj));
	}

	private AcousticGuitarProxy(Object obj) {
		this.fieldsMap = new HashMap<>();
		this.object = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().contains("set")) {
			throw new AccessException("can't invoke set method!");
		}
		Object result;
		result = method.invoke(object, args);
		return result;
	}
}
