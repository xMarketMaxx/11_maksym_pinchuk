package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

	private static Map<String, Command> commandContainer = new HashMap<>();

	public static void init() {
		commandContainer.put("add to shopping bag", new AddToShoppingBugCommand());
		commandContainer.put("exit", new ExitCommand());
		commandContainer.put("make order", new MakeOrderCommand());
		commandContainer.put("no command", new NoCommand());
		commandContainer.put("show shopping bag", new ShowShoppingBagCommand());
		commandContainer.put("show last added", new ShowLastAddedCommand());
		commandContainer.put("show order by date", new ShowOrderByDateCommand());
		commandContainer.put("show orders by period", new ShowOrdersByPeriodCommand());
		commandContainer.put("show product's list", new ShowProductsListCommand());
		commandContainer.put("add new acoustic guitar", new AddAcousticGuitarCommand());
		commandContainer.put("add new annotated acoustic guitar", new AddAnnotatedAcousticGuitarCommand());
		commandContainer.put("add new electic guitar", new AddElectricGuitarCommand());
		commandContainer.put("add new synthesizer guitar", new AddElectricGuitarCommand());
	}

	public static Command getCommand(String commandName) {
		if (commandName == null || !commandContainer.containsKey(commandName)) {
			return commandContainer.get("no command");
		}
		return commandContainer.get(commandName);
	}

}
