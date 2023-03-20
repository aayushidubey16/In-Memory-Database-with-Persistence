package main.java.inventory.command;

import main.java.inventory.impl.InventoryImpl;

/**
 * The Interface Command.
 */
public interface Command {
	
	/**
	 * Execute.
	 *
	 * @param inventory the inventory
	 * @throws Exception the exception
	 */
	public void execute(InventoryImpl inventory) throws Exception;
	
	/**
	 * Undo.
	 *
	 * @param inventory the inventory
	 * @throws Exception the exception
	 */
	public void undo(InventoryImpl inventory) throws Exception;

}
