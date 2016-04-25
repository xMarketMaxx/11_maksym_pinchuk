package ua.epam.java.subgroup11.pinchuk.task2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.AccessException;
import java.util.HashMap;
import java.util.Map;

public class AcousticGuitarProxy implements InvocationHandler {

	Map<String, Object> fields;
	Object object;

	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new AcousticGuitarProxy(obj));
	}

	public AcousticGuitarProxy(Object object) {
		fields = new HashMap<>();
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().startsWith("set")) {
			System.out.println("Proxy, (method:" + method.getName() + ", parameters:" + args[0] + ")");
			return fields.put(method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4), args[0]);
		} else if (method.getName().startsWith("get")) {
			String parameter = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
			System.out.println("Proxy, (method:" + method.getName() + ", parameters:" + parameter + ")");
			return fields.get(parameter);
		} else if (method.getName().startsWith("is")) {
			System.out.println("Proxy is:" + method.getName());
			return fields.get(method.getName().substring(2, 3).toLowerCase() + method.getName().substring(3));
		}
		throw new UnsupportedOperationException();
	}

}
