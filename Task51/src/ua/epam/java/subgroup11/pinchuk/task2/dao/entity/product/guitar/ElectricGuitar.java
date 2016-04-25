package ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.guitar;

import ua.epam.java.subgroup11.pinchuk.task2.annotation.GetSetField;

public class ElectricGuitar extends Guitar {

	private static final long serialVersionUID = 5403075525310551997L;
	
	private String pickup;

	public ElectricGuitar() {
	}

	public ElectricGuitar(String title, int price, String color, int stringsNumber, String pickup) {
		super(title, price, color, stringsNumber);
		this.pickup = pickup;
	}

	public String getPickup() {
		return pickup;
	}
	
	@GetSetField(fieldName = "pickup")
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = super.hashCode() * prime;
		if (pickup != null) {
			for (int i = 0; i < pickup.length(); i++) {
				result += prime * i * pickup.charAt(i);
			}
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		ElectricGuitar other = (ElectricGuitar) obj;
		if (pickup == null) {
			if (other.pickup != null) {
				return false;
			}
		} else if (!pickup.equals(other.pickup)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", pickup:" + pickup;
	}
}
