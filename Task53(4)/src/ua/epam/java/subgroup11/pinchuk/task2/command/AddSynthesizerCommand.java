package ua.epam.java.subgroup11.pinchuk.task2.command;

import ua.epam.java.subgroup11.pinchuk.task2.dao.entity.product.keyboard.Synthesizer;
import ua.epam.java.subgroup11.pinchuk.task2.service.Service;
import ua.epam.java.subgroup11.pinchuk.task2.utils.Inputter;

public class AddSynthesizerCommand extends Command {

	@Override
	public void execute(Service service, Inputter inputter) {
		Synthesizer newSynthesizer = new Synthesizer();
		newSynthesizer.setAutoAccompaniment(inputter.getBoolean("Input synthesizer auto accompaniment (true/false)"));
		newSynthesizer.setColor(inputter.getString("Input synthesizer color"));
		newSynthesizer.setHeight(inputter.getInt("Input synthesizer hight"));
		newSynthesizer.setKeysNumber(inputter.getInt("Input synthesizer keys number"));
		newSynthesizer.setLength(inputter.getInt("Input synthesizer lenght"));
		newSynthesizer.setNumberOfPresetSong(inputter.getInt("Input synthesizer number of preset songs"));
		newSynthesizer.setPrice(inputter.getInt("Input synthesizer price"));
		newSynthesizer.setSize(inputter.getInt("Input synthesizer hight"), inputter.getInt("Input synthesizer width"),
				inputter.getInt("Input synthesizer lenght"));
		newSynthesizer.setTitle(inputter.getString("Input synthesizer title"));
		newSynthesizer.setWidth(inputter.getInt("Input synthesizer width"));
		newSynthesizer.setUsbInput(inputter.getBoolean("Input synthesizer usb (true/false)"));

		service.addProductToStorage(newSynthesizer);
		System.out.println("New Synthesizer was added");

	}

}
