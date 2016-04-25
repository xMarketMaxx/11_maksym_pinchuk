package ua.epam.java.subgroup11.pinchuk.task2.command;

import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.ConsoleOutputter;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class ShowShoppingBagCommand extends Command {

	@Override
	public void execute(Service service, Inputter inputter) {
		System.out.println("Содержимое корзины:");
		ConsoleOutputter.printMapContent(service.getShoppingBagContent());
	}

}
