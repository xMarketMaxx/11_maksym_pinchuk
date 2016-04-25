package ua.epam.java.subgroup11.pinchuk.task2.command;

import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public abstract class Command {

	public abstract void execute(Service service, Inputter inputter);
}
