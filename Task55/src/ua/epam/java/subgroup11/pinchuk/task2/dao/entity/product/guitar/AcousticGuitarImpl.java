package ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.guitar;

import java.lang.reflect.Proxy;

import ua.epam.java.subgroup11.pinchuk.task2.annotation.FieldAnno;
import ua.epam.java.subgroup11.pinchuk.task2.proxy.AcousticGuitarProxy;

public class AcousticGuitarImpl extends Guitar implements AcousticGuitar {

	private static final long serialVersionUID = 9210306744965714056L;
	private int soundHoleSize;

	public AcousticGuitarImpl() {
	}

	public AcousticGuitarImpl(String title, int price, String color, int stringsNumber, int soundHoleSize) {
		super(title, price, color, stringsNumber);
		if (soundHoleSize < 0) {
			throw new IllegalArgumentException();
		}
		this.soundHoleSize = soundHoleSize;
	}

	public int getSoundHoleSize() {
		return soundHoleSize;
	}

	@FieldAnno(fieldName = "soundHoleSize")
	public void setSoundHoleSize(int soundHoleSize) {
		if (soundHoleSize < 0) {
			throw new IllegalArgumentException("Size of soundhole cannot be less than 0 (sezo)");
		}
		this.soundHoleSize = soundHoleSize;
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = super.hashCode() + prime * soundHoleSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		AcousticGuitarImpl other = (AcousticGuitarImpl) obj;
		if (soundHoleSize != other.soundHoleSize) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", soundhole size:" + soundHoleSize;
	}

	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new AcousticGuitarProxy(obj));
	}
}
