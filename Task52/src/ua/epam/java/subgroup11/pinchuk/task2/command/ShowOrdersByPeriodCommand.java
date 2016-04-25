package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.Order;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.ConsoleOutputter;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class ShowOrdersByPeriodCommand extends Command {

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

	@Override
	public void execute(Service service, Inputter inputter) {
		Date fromDate = getDate(inputter, "Введите начальную дату заказа для поиска (yyyy-MM-dd HH:mm): ");
		Date toDate = getDate(inputter, "Введите конечную дату заказа для поиска (yyyy-MM-dd HH:mm): ");
		for (Order o : service.getOrdersByDatesRange(fromDate, toDate)) {
			ConsoleOutputter.printOrder(o);
		}
	}

	private Date getDate(Inputter inputter, String str) {
		do {
			String stringDate = inputter.getString(str);
			try {
				return new Date(simpleDateFormat.parse(stringDate).getTime());
			} catch (ParseException e) {
			}
			System.out.print("Некорректный ввод!");
		} while (true);
	}

}
