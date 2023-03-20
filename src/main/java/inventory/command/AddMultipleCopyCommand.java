package main.java.inventory.command;

import java.io.Serializable;

import main.java.inventory.impl.InventoryImpl;

/**
 * The Class AddMultipleCopyCommand.
 */
public class AddMultipleCopyCommand implements Command, Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4406040603225256556L;
	
	/** The id. */
	private Integer id;
	
	/** The number of copy. */
	private Integer numberOfCopy;
	
	/**
	 * Instantiates a new adds the multiple copy command.
	 *
	 * @param id the id
	 * @param numberOfCopy the number of copy
	 */
	public AddMultipleCopyCommand(Integer id, Integer numberOfCopy) {
		super();
		this.id = id;
		this.numberOfCopy = numberOfCopy;
	}

	/**
	 * Execute.
	 *
	 * @param inventory the inventory
	 * @throws Exception the exception
	 */
	@Override
	public void execute(InventoryImpl inventory) throws Exception {
		inventory.addMultipleCopy(id, numberOfCopy);
	}

	/**
	 * Undo.
	 *
	 * @param inventory the inventory
	 * @throws Exception the exception
	 */
	@Override
	public void undo(InventoryImpl inventory) throws Exception {
		inventory.sellMultipleCopy(id, numberOfCopy);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AddMultipleCopyCommand [id=" + id + ", numberOfCopy=" + numberOfCopy + "]";
	}

}
