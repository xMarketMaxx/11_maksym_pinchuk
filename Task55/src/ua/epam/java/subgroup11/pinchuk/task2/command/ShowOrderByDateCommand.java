package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.ConsoleOutputter;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class ShowOrderByDateCommand extends Command {

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

	@Override
	public void execute(Service service, Inputter inputter) {
		Date date = getDate(inputter);
		ConsoleOutputter.printOrder(service.getNearestOrderByDate(date));
	}

	private Date getDate(Inputter inputter) {
		do {
			String stringDate = inputter.getString("Введите дату заказа (yyyy-MM-dd HH:mm): ");
			try {
				return new Date(simpleDateFormat.parse(stringDate).getTime());
			} catch (ParseException e) {
			}
			System.out.print("Некорректный ввод!");
		} while (true);
	}

}
