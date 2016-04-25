package ua.epam.java.subgroup11.pinchuk.task2.utils;

import java.util.Scanner;

public class ConsoleInputter implements Inputter {

	private Scanner in = new Scanner(System.in);

	@Override
	public int getInt(String str) {
		System.out.println("Введите поле \"" + str + "\":");

		while (true) {
			try {
				return Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
			}
			System.out.println("Некоррекный ввод, повторите!:");
		}
	}

	@Override
	public String getString(String str) {
		System.out.println("Введите поле \"" + str + "\":");
		return in.nextLine();
	}

	@Override
	public Boolean getBoolean(String str) {
		System.out.println("Введите поле \"" + str + "\":");

		while (true) {
			try {
				return Boolean.parseBoolean(in.nextLine());
			} catch (NumberFormatException e) {
			}
			System.out.println("Некоррекный ввод, повторите!");
		}
	}

}
