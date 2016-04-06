package ua.epam.java.subgroup11.pinchuk.task11.musicdepartment.guitar;

public class AcousticGuitar extends Guitar {

	private int soundHoleSize;

	public AcousticGuitar() {
	}

	public AcousticGuitar(String title) {
		super(title);
	}

	public int getSoundHoleSize() {
		return soundHoleSize;
	}

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
		AcousticGuitar other = (AcousticGuitar) obj;
		if (soundHoleSize != other.soundHoleSize) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + 
				", soundhole size:" + soundHoleSize;
	}
}
