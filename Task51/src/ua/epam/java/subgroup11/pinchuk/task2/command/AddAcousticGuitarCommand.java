package ua.epam.java.subgroup11.pinchuk.task2.command;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.guitar.AcousticGuitar;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class AddAcousticGuitarCommand extends Command {

	@Override
	public void execute(Service service, Inputter inputter) {
		AcousticGuitar newGuitar = new AcousticGuitar();
		newGuitar.setColor(inputter.getString("Input acoustic guitar color"));
		newGuitar.setPrice(inputter.getInt("Input acoustic guitar price"));
		newGuitar.setSoundHoleSize(inputter.getInt("Input acoustic guitar soundhole size"));
		newGuitar.setStringsCount(inputter.getInt("Input acoustic guitar string count"));
		newGuitar.setTitle(inputter.getString("Input acoustic guitar title"));

		service.addProductToStorage(newGuitar);
		System.out.println("New acoustic guitar was added");
	}

}
