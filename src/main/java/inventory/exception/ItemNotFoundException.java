package main.java.inventory.exception;

/**
 * The Class ItemNotFoundException.
 */
public class ItemNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3753631596416135838L;

	/**
	 * Instantiates a new item not found exception.
	 *
	 * @param name the name
	 */
	public ItemNotFoundException(String name) {
		super("Item not Found in the inventory with name : "+ name);
	}
	
	/**
	 * Instantiates a new item not found exception.
	 *
	 * @param id the id
	 */
	public ItemNotFoundException(Integer id) {
		super("Item not Found in the inventory with id : "+ id);
	}

}
