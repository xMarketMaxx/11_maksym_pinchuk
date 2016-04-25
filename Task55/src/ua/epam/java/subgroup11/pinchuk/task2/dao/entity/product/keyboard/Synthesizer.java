package ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.keyboard;

public class Synthesizer extends MusicalKeyboard {

	private boolean usbInput;
	private boolean autoAccompaniment;
	private int numberOfPresetSong;

	public Synthesizer() {
	}

	public Synthesizer(String title, int price, int keysNumber, int height, int width, int length, String color,
			boolean usbInput, boolean autoAccompaniment, int numberOfPresetSong) {
		super(title, price, keysNumber, height, width, length, color);
		if (numberOfPresetSong < 0) {
			throw new IllegalArgumentException("Number of preset song cannot be less than 0 (zero)");
		}
		this.autoAccompaniment = autoAccompaniment;
		this.usbInput = usbInput;
		this.numberOfPresetSong = numberOfPresetSong;
	}

	public boolean isUsbInput() {
		return usbInput;
	}

	public void setUsbInput(boolean usbInput) {
		this.usbInput = usbInput;
	}

	public boolean isAutoAccompaniment() {
		return autoAccompaniment;
	}

	public void setAutoAccompaniment(boolean autoAccompaniment) {
		this.autoAccompaniment = autoAccompaniment;
	}

	public int getNumberOfPresetSong() {
		return numberOfPresetSong;
	}

	public void setNumberOfPresetSong(int numberOfPresetSong) {
		if (numberOfPresetSong < 0) {
			throw new IllegalArgumentException("Number of preset song cannot be less than 0 (zero)");
		}
		this.numberOfPresetSong = numberOfPresetSong;
	}

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		if (usbInput) {
			result += prime;
		}
		if (autoAccompaniment) {
			result += prime;
		}
		result += prime * numberOfPresetSong + super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		Synthesizer other = (Synthesizer) obj;
		if (usbInput != other.usbInput) {
			return false;
		}
		if (autoAccompaniment != other.autoAccompaniment) {
			return false;
		}
		if (numberOfPresetSong != other.numberOfPresetSong) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", USB input:" + usbInput + ", auto accompaniment:" + autoAccompaniment
				+ ", number of preset song:" + numberOfPresetSong;
	}
}
