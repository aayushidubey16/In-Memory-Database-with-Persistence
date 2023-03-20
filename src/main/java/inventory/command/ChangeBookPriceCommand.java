package main.java.inventory.command;

import java.io.Serializable;

import main.java.inventory.impl.InventoryImpl;

/**
 * The Class ChangeBookPriceCommand.
 */
public class ChangeBookPriceCommand implements Command, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3387215162202423371L;
	
	/** The id. */
	private Integer id;
	
	/** The price. */
	private Float price;
	
	/** The old price. */
	private Float oldPrice;
	
	/**
	 * Instantiates a new change book price command.
	 *
	 * @param id the id
	 * @param price the price
	 */
	public ChangeBookPriceCommand(Integer id, Float price) {
		super();
		this.id = id;
		this.price = price;
	}

	/**
	 * Execute.
	 *
	 * @param inventory the inventory
	 * @throws Exception the exception
	 */
	@Override
	public void execute(InventoryImpl inventory) throws Exception {
		this.oldPrice = inventory.findPriceById(id);
		inventory.changePrice(id, price);
	}

	/**
	 * Undo.
	 *
	 * @param inventory the inventory
	 * @throws Exception the exception
	 */
	@Override
	public void undo(InventoryImpl inventory) throws Exception {
		inventory.changePrice(id, oldPrice);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ChangeBookPriceCommand [id=" + id + ", price=" + price + ", oldPrice=" + oldPrice + "]";
	}

}
