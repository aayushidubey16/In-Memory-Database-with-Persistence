package main.java.inventory.command;

import java.io.Serializable;

import main.java.inventory.exception.ItemNotFoundException;
import main.java.inventory.impl.InventoryImpl;

/**
 * The Class SellBook.
 */
public class SellBook implements Command, Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6103259387258526219L;
	
	/** The id. */
	private Integer id;
	
	/**
	 * Instantiates a new sell book.
	 *
	 * @param id the id
	 */
	public SellBook(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Execute.
	 *
	 * @param inventory the inventory
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void execute(InventoryImpl inventory) throws ItemNotFoundException {
		inventory.sell(id);
	}

	/**
	 * Undo.
	 *
	 * @param inventory the inventory
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void undo(InventoryImpl inventory) throws ItemNotFoundException {
		inventory.addMultipleCopy(id, 1);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SellBook [id=" + id + "]";
	}

}
