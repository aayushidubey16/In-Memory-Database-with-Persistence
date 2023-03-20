package main.java.inventory.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.inventory.Inventory;
import main.java.inventory.command.AddBookCommand;
import main.java.inventory.command.AddMultipleCopyCommand;
import main.java.inventory.command.ChangeBookPriceCommand;
import main.java.inventory.command.Command;
import main.java.inventory.command.SellBook;
import main.java.inventory.command.SellMultipleCopyCommand;
import main.java.inventory.exception.ItemNotFoundException;
import main.java.inventory.model.Book;
import main.java.inventory.utils.Constants;
import main.java.inventory.utils.Utils;

/**
 * The Class BookInventory.
 */
public class BookInventory implements Inventory {
	
	/** The inventory. */
	private InventoryImpl inventory;
	
	/** The commands. */
	private List<Command> commands;
	
	/** The inventory memento. */
	private InventoryMemento inventoryMemento;
	
	/**
	 * Instantiates a new book inventory.
	 *
	 * @param inventoryImpl the inventory impl
	 */
	public BookInventory(InventoryImpl inventoryImpl) {
		super();
		this.inventory = inventoryImpl;
		this.commands = new ArrayList<>();
		intiallize();
	}

	/**
	 * Intiallize.
	 */
	private void intiallize() {
		reloadingMementoIfExists();
		inventory.restoreFromMemento(inventoryMemento);
		replayCommandsIfExists();
	}

	/**
	 * Adds the.
	 *
	 * @param book the book
	 */
	@Override
	public void add(Book book) {
		try {
			executeCommandAndPersisT(new AddBookCommand(book));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sell.
	 *
	 * @param id the id
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void sell(Integer id) throws ItemNotFoundException {
		try {
			executeCommandAndPersisT(new SellBook(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sell multiple copy.
	 *
	 * @param id the id
	 * @param quantity the quantity
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void sellMultipleCopy(Integer id, Integer quantity) throws ItemNotFoundException {
		inventory.sellMultipleCopy(id, quantity);
		try {
			executeCommandAndPersisT(new SellMultipleCopyCommand(id, quantity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds the multiple copy.
	 *
	 * @param id the id
	 * @param copiesCount the copies count
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void addMultipleCopy(Integer id, Integer copiesCount) throws ItemNotFoundException {
		inventory.addMultipleCopy(id, copiesCount);
		try {
			executeCommandAndPersisT(new AddMultipleCopyCommand(id, copiesCount));
		} catch (Exception e) {
		}
	}

	/**
	 * Change price.
	 *
	 * @param id the id
	 * @param newPrice the new price
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void changePrice(Integer id, Float newPrice) throws ItemNotFoundException {
		inventory.changePrice(id, newPrice);
		try {
			executeCommandAndPersisT(new ChangeBookPriceCommand(id, newPrice));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Find price by name.
	 *
	 * @param name the name
	 * @return the float
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public Float findPriceByName(String name) throws ItemNotFoundException {
		return inventory.findPriceByName(name);
	}

	/**
	 * Find price by id.
	 *
	 * @param id the id
	 * @return the float
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public Float findPriceById(Integer id) throws ItemNotFoundException {
		return inventory.findPriceById(id);
	}

	/**
	 * Find quantity by name.
	 *
	 * @param name the name
	 * @return the integer
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public Integer findQuantityByName(String name) throws ItemNotFoundException {
		return inventory.findQuantityByName(name);
	}

	/**
	 * Find quantity by id.
	 *
	 * @param id the id
	 * @return the integer
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public Integer findQuantityById(Integer id) throws ItemNotFoundException {
		return inventory.findQuantityById(id);
	}

	/**
	 * Removes the.
	 *
	 * @param item the item
	 */
	@Override
	public void remove(Book item) {
		inventory.remove(item);
	}
	
	/**
	 * Execute command and persis T.
	 *
	 * @param command the command
	 * @throws Exception the exception
	 */
	private void executeCommandAndPersisT(Command command) throws Exception{
		command.execute(inventory);
		commands.add(command);
		Utils.writeToFile(command, Constants.COMMAND_FILE_PATH, Boolean.TRUE);
		if (commands.size() == 10) {
			this.saveMementoState();
		}
	}
	
	/**
	 * Save memento state.
	 */
	private void saveMementoState() {
		InventoryMemento saveInventoryState = inventory.createMemento();
		Utils.delete(Constants.MEMENTO_FILE_PATH);
		Utils.writeToFile(saveInventoryState, Constants.MEMENTO_FILE_PATH, Boolean.FALSE);
		Utils.delete(Constants.COMMAND_FILE_PATH);
		commands.clear();
		inventoryMemento = saveInventoryState;
	}
	
	/**
	 * Reloading memento if exists.
	 */
	private void reloadingMementoIfExists() {
		inventoryMemento = (InventoryMemento) Utils.readObjectFromFile(Constants.MEMENTO_FILE_PATH);
		if(inventoryMemento == null) {
			inventoryMemento = inventory.createMemento();
		}
	}
	
	/**
	 * Replay commands if exists.
	 */
	private void replayCommandsIfExists() {
		commands.addAll(Utils.readObjectsFromFile(Constants.COMMAND_FILE_PATH));
		for (Command command : commands) {
			try {
				command.execute(inventory);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Size.
	 *
	 * @return the integer
	 */
	@Override
	public Integer size() {
		return inventory.size();
	}

}
