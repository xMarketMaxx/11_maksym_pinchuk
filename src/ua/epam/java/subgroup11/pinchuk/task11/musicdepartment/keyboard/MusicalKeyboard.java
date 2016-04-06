package ua.epam.java.subgroup11.pinchuk.task11.musicdepartment.keyboard;

import ua.epam.java.subgroup11.pinchuk.task11.Product;

public abstract class MusicalKeyboard extends Product {

	private int keysNumber;
	private int height;
	private int width;
	private int length;
	private String color;

	public MusicalKeyboard() {
	}

	public MusicalKeyboard(String title) {
		super(title);
	}

	public int getKeysNumber() {
		return keysNumber;
	}

	public void setKeysNumber(int keysNumber) {
		this.keysNumber = keysNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSize(int height, int width, int length) {
		setHeight(height);
		setWidth(width);
		setLength(length);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height < 0) {
			throw new IllegalArgumentException("Height cannot be less than 0(zero)");
		}
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width < 0) {
			throw new IllegalArgumentException("Width cannot be less than 0(zero)");
		}
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("Length cannot be less than 0(zero)");
		}
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result += prime * keysNumber + super.hashCode() + prime * height + prime * width + prime * length;
		for (int i = 0; i < color.length(); i++) {
			result += prime * i * color.charAt(i);
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		MusicalKeyboard other = (MusicalKeyboard) obj;
		if (keysNumber != other.keysNumber) {
			return false;
		}
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		if (length != other.length) {
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
		return super.toString() + ", color:" + color + ", number of keys:" + keysNumber + ", height:" + height
				+ ", width:" + width + ", length:" + length;
	}

}
