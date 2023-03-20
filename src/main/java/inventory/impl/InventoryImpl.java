package main.java.inventory.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.inventory.Inventory;
import main.java.inventory.exception.ItemNotFoundException;
import main.java.inventory.model.Book;

/**
 * The Class InventoryImpl.
 */
public class InventoryImpl implements Inventory {
	
	/** The book collection. */
	private List<Book> bookCollection;
	
	/** The id sequence. */
	private Integer idSequence;

	/**
	 * Instantiates a new inventory impl.
	 */
	public InventoryImpl() {
		super();
		bookCollection = new ArrayList<Book>();
		idSequence = 0;
	}

	/**
	 * Adds the.
	 *
	 * @param book the book
	 */
	@Override
	public void add(Book book) {
		book.setId(++idSequence);
		System.out.println(idSequence + "***" + bookCollection.size());
		bookCollection.add(book);
	}

	/**
	 * Sell.
	 *
	 * @param id the id
	 * @throws ItemNotFoundException the item not found exception
	 */
	@Override
	public void sell(Integer id) throws ItemNotFoundException {
		for (Book book : bookCollection) {
			if ((book.getQuantity() > 0) && book.isIdEqual(id)) {
				book.decrementQuantity();
				return;
			}
		}
		throw new ItemNotFoundException(id);
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
		for (Book book : bookCollection) {
			if ((book.getQuantity() > 0) && book.isIdEqual(id)) {
				book.decrementQuantity(quantity);
				return;
			}
		}
		throw new ItemNotFoundException(id);
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
		for (Book book : bookCollection) {
			if ((book.getQuantity() > 0) && book.isIdEqual(id)) {
				book.incrementQuantity(copiesCount);
				return;
			}
		}
		throw new ItemNotFoundException(id);
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
		for (Book book : bookCollection) {
			if ((book.getQuantity() > 0) && book.isIdEqual(id)) {
				book.setPrice(newPrice);
				return;
			}
		}
		throw new ItemNotFoundException(id);
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
		for (Book book : bookCollection) {
			if ((book.getQuantity() > 0) && book.getName().equalsIgnoreCase(name)) {
				return book.getPrice();
			}
		}
		throw new ItemNotFoundException(name);
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
		for (Book book : bookCollection) {
			if ((book.getQuantity() > 0) && book.isIdEqual(id)) {
				return book.getPrice();
			}
		}
		throw new ItemNotFoundException(id);
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
		for (Book book : bookCollection) {
			if ((book.getQuantity() > 0) && book.getName().equalsIgnoreCase(name)) {
				return book.getQuantity();
			}
		}
		throw new ItemNotFoundException(name);
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
		for (Book book : bookCollection) {
			if ((book.getQuantity() > 0) && book.isIdEqual(id)) {
				return book.getQuantity();
			}
		}
		throw new ItemNotFoundException(id);
	}

	/**
	 * Removes the.
	 *
	 * @param item the item
	 */
	@Override
	public void remove(Book item) {
		bookCollection.remove(item);
	}
	
	/**
	 * Creates the memento.
	 *
	 * @return the inventory memento
	 */
	public InventoryMemento createMemento() {
		List<Book> mementoItems = new ArrayList<Book>();
		System.out.println(bookCollection.size());
		bookCollection.forEach(book-> {
			try {
				mementoItems.add((Book) book.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});
		return new InventoryMemento(bookCollection, idSequence);
	}
	
	/**
	 * Restore from memento.
	 *
	 * @param memento the memento
	 */
	public void restoreFromMemento(InventoryMemento memento) {
		List<Book> mementoItems = new ArrayList<Book>();
		memento.getBookCollection().forEach(book-> {
			try {
				mementoItems.add((Book) book.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});
		bookCollection = mementoItems;
		idSequence = memento.getIdSequence();
	}

	/**
	 * Size.
	 *
	 * @return the integer
	 */
	@Override
	public Integer size() {
		return bookCollection.size();
	}

}
