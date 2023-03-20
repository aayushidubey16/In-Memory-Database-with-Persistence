package main.java.inventory.command;

import java.io.Serializable;

import main.java.inventory.exception.ItemNotFoundException;
import main.java.inventory.impl.InventoryImpl;

/**
 * The Class SellMultipleCopyCommand.
 */
public class SellMultipleCopyCommand implements Command, Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6103259387258526219L;
	
	/** The id. */
	private Integer id;
	
	/** The number of copy. */
	private Integer numberOfCopy;
	
	/**
	 * Instantiates a new sell multiple copy command.
	 *
	 * @param id the id
	 * @param numberOfCopy the number of copy
	 */
	public SellMultipleCopyCommand(Integer id, Integer numberOfCopy) {
		super();
		this.id = id;
		this.numberOfCopy = numberOfCopy;
	}

	/**
	 * Execute.
	 *
	 * @param inventory the inventory
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void execute(InventoryImpl inventory) throws ItemNotFoundException {
		inventory.sellMultipleCopy(id, numberOfCopy);
	}

	/**
	 * Undo.
	 *
	 * @param inventory the inventory
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void undo(InventoryImpl inventory) throws ItemNotFoundException {
		inventory.addMultipleCopy(id, numberOfCopy);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SellMultipleCopyCommand [id=" + id + ", numberOfCopy=" + numberOfCopy + "]";
	}

}
