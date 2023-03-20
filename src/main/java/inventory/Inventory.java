package main.java.inventory;

import main.java.inventory.exception.ItemNotFoundException;
import main.java.inventory.model.Book;

/**
 * The Interface Inventory.
 */
public interface Inventory  {
	
	/**
	 * Adds the.
	 *
	 * @param book the book
	 */
	public void add(Book book);
	
	/**
	 * Sell.
	 *
	 * @param id the id
	 * @throws ItemNotFoundException the item not found exception
	 */
	public void sell(Integer id) throws ItemNotFoundException;
	
	/**
	 * Sell multiple copy.
	 *
	 * @param id the id
	 * @param quantity the quantity
	 * @throws ItemNotFoundException the item not found exception
	 */
	public void sellMultipleCopy(Integer id, Integer quantity) throws ItemNotFoundException;
	
	/**
	 * Adds the multiple copy.
	 *
	 * @param id the id
	 * @param copiesCount the copies count
	 * @throws ItemNotFoundException the item not found exception
	 */
	public void addMultipleCopy(Integer id, Integer copiesCount) throws ItemNotFoundException;
	
	/**
	 * Change price.
	 *
	 * @param id the id
	 * @param newPrice the new price
	 * @throws ItemNotFoundException the item not found exception
	 */
	public void changePrice(Integer id, Float newPrice) throws ItemNotFoundException;

	/**
	 * Find price by name.
	 *
	 * @param name the name
	 * @return the float
	 * @throws ItemNotFoundException the item not found exception
	 */
	public Float findPriceByName(String name) throws ItemNotFoundException;

	/**
	 * Find price by id.
	 *
	 * @param id the id
	 * @return the float
	 * @throws ItemNotFoundException the item not found exception
	 */
	public Float findPriceById(Integer id) throws ItemNotFoundException;
	
	/**
	 * Find quantity by name.
	 *
	 * @param name the name
	 * @return the integer
	 * @throws ItemNotFoundException the item not found exception
	 */
	public Integer findQuantityByName(String name) throws ItemNotFoundException;

	/**
	 * Find quantity by id.
	 *
	 * @param id the id
	 * @return the integer
	 * @throws ItemNotFoundException the item not found exception
	 */
	public Integer findQuantityById(Integer id) throws ItemNotFoundException;

	/**
	 * Removes the.
	 *
	 * @param book the book
	 */
	public void remove(Book book);
	
	/**
	 * Size.
	 *
	 * @return the integer
	 */
	public Integer size();
	
}
