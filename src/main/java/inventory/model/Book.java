package main.java.inventory.model;

import java.io.Serializable;

/**
 * The Class Book.
 */
public class Book implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6485588640475531154L;
	
	/** The id. */
	protected Integer id;
	
	/** The name. */
	protected String name;
	
	/** The price. */
	protected Float price;
	
	/** The quantity. */
	protected Integer quantity;
	
	/** The author. */
	public String author;
    
    /** The year. */
    public Integer year;
    
    /** The publisher. */
    public String publisher;
    
	/**
	 * Instantiates a new book.
	 *
	 * @param id the id
	 * @param name the name
	 * @param price the price
	 * @param quantity the quantity
	 * @param author the author
	 * @param year the year
	 * @param publisher the publisher
	 */
	public Book(Integer id, String name, Float price, Integer quantity, String author, Integer year, String publisher) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.author = author;
		this.year = year;
		this.publisher = publisher;
	}
	
	/**
	 * Instantiates a new book.
	 *
	 * @param name the name
	 * @param price the price
	 * @param quantity the quantity
	 * @param author the author
	 * @param year the year
	 * @param publisher the publisher
	 */
	public Book(String name, Float price, Integer quantity, String author, Integer year, String publisher) {
		this.name = name; 
		this.price = price; 
		this.quantity = quantity;
		this.author = author;
		this.year = year;
		this.publisher = publisher;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Checks if is id equal.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	public Boolean isIdEqual(Integer id) {
		return this.id.equals(id);
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Decrement quantity.
	 */
	public void decrementQuantity() {
		decrementQuantity(1);
	}
	
	/**
	 * Increment quantity.
	 */
	public void incrementQuantity() {
		incrementQuantity(1);
	}
	
	/**
	 * Decrement quantity.
	 *
	 * @param quantityToDeduct the quantity to deduct
	 */
	public void decrementQuantity(Integer quantityToDeduct) {
		this.quantity-=quantityToDeduct;
	}
	
	/**
	 * Increment quantity.
	 *
	 * @param quantityToAdd the quantity to add
	 */
	public void incrementQuantity(Integer quantityToAdd) {
		this.quantity+=quantityToAdd;
	}
	
	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}
	
	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	
	/**
	 * Gets the publisher.
	 *
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * Sets the publisher.
	 *
	 * @param publisher the new publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Book [author=" + author + ", year=" + year + ", publisher=" + publisher + ", id=" + id + ", name="
				+ name + ", price=" + price + ", quantity=" + quantity + "]";
	}

	/**
	 * Clone.
	 *
	 * @return the object
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Book(id, name, price, quantity, author, year, publisher);
	}

}
