package ua.epam.java.subgroup11.pinchuk.task1.task11;

public abstract class Product {

	private String title;
	private int price;

	public Product() {
	}

	public Product(String title, int price) {
		this.title = title;
		if(price < 0){
			throw new IllegalArgumentException();
		}
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price < 0){
			throw new IllegalArgumentException("Price cannot be less than 0 (zero)");
		}
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result += prime * result + price;
		for (int i = 0; i < title.length(); i++) {
			result += prime * i * title.charAt(i);
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Title:" + title + 
				", price:" + price / 100 + 
				"." + price % 100;
	}
}
