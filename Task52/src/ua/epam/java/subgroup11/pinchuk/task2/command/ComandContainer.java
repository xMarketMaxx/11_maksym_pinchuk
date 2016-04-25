package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.util.HashMap;
import java.util.Map;

public class ComandContainer {

	private static Map<String, Command> commandContainer = new HashMap<>();

	public static void init() {
		commandContainer.put("show product's list", new ShowProductsListCommand());
		commandContainer.put("add to shopping bag", new AddToShoppingBugCommand());
		commandContainer.put("show shopping bag", new ShowShoppingBagCommand());
		commandContainer.put("make order", new MakeOrderCommand());
		commandContainer.put("show last added", new ShowLastAddedCommand());
		commandContainer.put("show order by date", new ShowOrderByDateCommand());
		commandContainer.put("show orders by period", new ShowOrdersByPeriodCommand());
		commandContainer.put("exit", new ExitCommand());
		commandContainer.put("no command", new NoCommand());
		//////
		commandContainer.put("add new acoustic guitar", new AddAcousticGuitarCommand());
		commandContainer.put("add new electric guitar", new AddElectricGuitarCommand());
		commandContainer.put("add new synthesizer", new AddSynthesizerCommand());
	}

	public static Command getCommand(String commandName) {
		if (commandName == null || !commandContainer.containsKey(commandName)) {
			return commandContainer.get("noCommand");
		}
		return commandContainer.get(commandName);
	}

}
