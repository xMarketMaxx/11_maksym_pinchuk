package ua.epam.java.subgroup11.pinchuk.task2.command;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.guitar.ElectricGuitar;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class AddElectricGuitarCommand extends Command {

	@Override
	public void execute(Service service, Inputter inputter) {
		ElectricGuitar newGuitar = new ElectricGuitar();
		newGuitar.setColor(inputter.getString("Input electric guitar color"));
		newGuitar.setPrice(inputter.getInt("Input electric guitar price"));
		newGuitar.setStringsCount(inputter.getInt("Input electric guitar string count"));
		newGuitar.setTitle(inputter.getString("Input electric guitar title"));
		newGuitar.setPickup(inputter.getString("Input PickUp"));
		
		service.addProductToStorage(newGuitar);
		System.out.println("New electic guitar was added");

	}

}
