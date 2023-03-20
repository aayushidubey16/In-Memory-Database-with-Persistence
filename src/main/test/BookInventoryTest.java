package main.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.inventory.exception.ItemNotFoundException;
import main.java.inventory.impl.BookInventory;
import main.java.inventory.impl.InventoryImpl;
import main.java.inventory.model.Book;

class BookInventoryTest {
	
	private static BookInventory bookInventory;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		bookInventory = new BookInventory(new InventoryImpl());
	}

	@Test
	void testAdd() {
		bookInventory.add(new Book("Book1", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book2", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book3", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book4", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book5", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book6", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book7", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book8", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book9", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book10", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book11", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book12", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book13", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book14", 23f, 50, null, null, null));
		bookInventory.add(new Book("Book15", 23f, 50, null, null, null));
		assertEquals(30,bookInventory.size());
	}

	@Test
	void testSell() {
		try {
			bookInventory.sell(2);
			assertEquals(48, bookInventory.findQuantityById(2));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testSellMultipleCopy() {
		try {
			bookInventory.sellMultipleCopy(5, 10);
			assertEquals(30, bookInventory.findQuantityById(5));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testAddMultipleCopy() {
		try {
			bookInventory.addMultipleCopy(6, 10);
			assertEquals(70, bookInventory.findQuantityById(6));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testChangePrice() {
		try {
			bookInventory.changePrice(6, 43f);
			assertEquals(43f, bookInventory.findPriceById(6));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindPriceByName() {
		try {
			assertEquals(23f, bookInventory.findPriceByName("Book3"));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindPriceById() {
		try {
			assertEquals(23f, bookInventory.findPriceById(4));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindQuantityByName() {
		try {
			assertEquals(50, bookInventory.findQuantityByName("Book7"));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindQuantityById() {
		try {
			assertEquals(50, bookInventory.findQuantityById(14));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

}
