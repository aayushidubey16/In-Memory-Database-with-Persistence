package main.java.inventory.impl;

import java.io.Serializable;
import java.util.List;

import main.java.inventory.model.Book;

/**
 * The Class InventoryMemento.
 */
public class InventoryMemento implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2018925950377312927L;
	
	/** The book collection. */
	private List<Book> bookCollection;
	
	/** The id sequence. */
	private Integer idSequence;
	
	/**
	 * Instantiates a new inventory memento.
	 *
	 * @param bookCollection the book collection
	 * @param idSequence the id sequence
	 */
	public InventoryMemento(List<Book> bookCollection, Integer idSequence) {
		super();
		this.bookCollection = bookCollection;
		this.idSequence = idSequence;
	}
	
	/**
	 * Gets the id sequence.
	 *
	 * @return the id sequence
	 */
	public Integer getIdSequence() {
		return idSequence;
	}
	
	/**
	 * Sets the id sequence.
	 *
	 * @param idSequence the new id sequence
	 */
	public void setIdSequence(Integer idSequence) {
		this.idSequence = idSequence;
	}
	
	/**
	 * Gets the book collection.
	 *
	 * @return the book collection
	 */
	public List<Book> getBookCollection() {
		return bookCollection;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "InventoryMemento [bookCollection=" + bookCollection + ", idSequence=" + idSequence + "]";
	}

}
