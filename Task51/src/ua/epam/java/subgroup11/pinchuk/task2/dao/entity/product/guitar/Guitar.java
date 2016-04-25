package ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.guitar;

import ua.epam.java.subgroup11.pinchuk.task2.annotation.GetSetField;
import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.Product;

public abstract class Guitar extends Product {

	private static final long serialVersionUID = 8153380499525602549L;
	private int stringsNumber;
	private String color;

	public Guitar() {
	}

	public Guitar(String title, int price, String color, int stringsNumber) {
		super(title, price);
		if (stringsNumber < 0) {
			throw new IllegalArgumentException();
		}
		this.color = color;
		this.stringsNumber = stringsNumber;
	}

	public int getStringsCount() {
		return stringsNumber;
	}
	@GetSetField(fieldName = "stringsNumber")
	public void setStringsCount(int stringsCount) {
		if (stringsCount < 0) {
			throw new IllegalArgumentException("Strings count cannot be less than 0(zero)");
		}
		this.stringsNumber = stringsCount;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = prime * stringsNumber + super.hashCode();
		if (color != null) {
			for (int i = 0; i < color.length(); i++) {
				result += prime * i * color.charAt(i);
			}
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		Guitar other = (Guitar) obj;
		if (stringsNumber != other.stringsNumber) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", color:" + color + ", number of strings:" + stringsNumber;
	}
}
