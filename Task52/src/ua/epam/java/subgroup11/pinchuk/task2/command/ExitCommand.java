package ua.epam.java.subgroup11.pinchuk.task2.command;

import java.io.IOException;

import ua.epam.java.subgroup11.pinchuk.task2.dao.memory.ProductRepository;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class ExitCommand extends Command {

	@Override
	public void execute(Service service, Inputter inputter) {
		try {
			ProductRepository.saveRepository(ProductRepository.getInstance());
		} catch (IOException e) {
			System.out.println("Can't save productRepository!\n" + e);
		}
		System.out.println("Exit command! До скорой встречи!");
		System.exit(0);
	}
}
