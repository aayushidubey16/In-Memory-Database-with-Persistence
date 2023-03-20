package main.java.inventory.command;

import java.io.Serializable;

import main.java.inventory.impl.InventoryImpl;
import main.java.inventory.model.Book;

/**
 * The Class AddBookCommand.
 */
public class AddBookCommand implements Command, Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8623290590082606782L;
	
	/** The book. */
	private Book book;

	/**
	 * Instantiates a new adds the book command.
	 *
	 * @param book the book
	 */
	public AddBookCommand(Book book) {
		super();
		this.book = book;
	}

	/**
	 * Execute.
	 *
	 * @param inventory the inventory
	 */
	@Override
	public void execute(InventoryImpl inventory) {
		inventory.add(book);
	}

	/**
	 * Undo.
	 *
	 * @param inventory the inventory
	 */
	@Override
	public void undo(InventoryImpl inventory) {
		inventory.remove(book);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AddBookCommand [book=" + book + "]";
	}

}
