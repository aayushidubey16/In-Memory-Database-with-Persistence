package main.java.inventory.utils;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import main.java.inventory.command.Command;

/**
 * The Class Utils.
 */
public class Utils {
	
	/**
	 * Write to file.
	 *
	 * @param toSave the to save
	 * @param filePath the file path
	 * @param mode the mode
	 */
	public static void writeToFile(Object toSave, String filePath, boolean mode) {
		FileOutputStream fileStream;
		try {
			File file = new File(filePath);
			fileStream = new FileOutputStream(file, mode);
			ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
			objStream.writeObject(toSave);
			objStream.close();
			fileStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read object from file.
	 *
	 * @param filePath the file path
	 * @return the object
	 */
	public static Object readObjectFromFile(String filePath) {
		Object object = null;
		try {
			File mementoFile = new File(filePath);
			if (mementoFile.exists()) {
				FileInputStream fileStream = new FileInputStream(mementoFile);
				ObjectInputStream objStream = new ObjectInputStream(fileStream);
				object = objStream.readObject();
				System.out.println(object);
				objStream.close();
				fileStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	/**
	 * Read objects from file.
	 *
	 * @param filePath the file path
	 * @return the list
	 */
	public static List<Command> readObjectsFromFile(String filePath) {
		List<Command> commands = new ArrayList<>();
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(filePath);
			while (true) {
				ObjectInputStream input = new ObjectInputStream(fileIn);
				commands.add((Command)input.readObject());
			}
		} catch (EOFException e) {
			try {
				fileIn.close();
			} catch (IOException i) {
				i.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commands;
	}
	
	/**
	 * Delete.
	 *
	 * @param filePath the file path
	 */
	public static void delete(String filePath) {
		new File(filePath).delete();
	}

}
