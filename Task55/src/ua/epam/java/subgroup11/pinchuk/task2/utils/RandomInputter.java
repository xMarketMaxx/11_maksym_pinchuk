package ua.epam.java.subgroup11.pinchuk.task2.utils;

public class RandomInputter implements Inputter {
	
	@Override
	public int getInt(String str) {
		System.out.println("Generate " + str);
		return (int) (Math.random() * 10000);
	}

	@Override
	public String getString(String str) {
		System.out.println("Generate " + str);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Math.random() * 20; i++) {
			sb.append((char) ((Math.random() * 255 % 215) + 40));
		}
		return sb.toString();
	}

	@Override
	public Boolean getBoolean(String str) {
		System.out.println("Generate: " + str);
		return (Math.random() * 10) % 2 == 0 ? true : false;
	}
}
