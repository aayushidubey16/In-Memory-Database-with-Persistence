# In Memory Database with Persistence [Java]

● Designed an in-memory database for bookstore inventory that allows us to add, sell, update the quantity and price of books and
search for the book in the inventory.<br>
● Snapshotting intermediate state of Bookstore Inventory as a serialized object to rollback to a previous checkpoint later in time
with the help of Command and Memento patterns<br>
● Learned how to implement various design patterns side by side in a single project by weighing the pros and cons of each pattern.<br>
<br>

## Patten Implementation:

    ● Decorator Pattern:
        -Component: Inventory.java
        -ConcreteComponent: InventoryImpl.java
        -Decorator: BookInventory.java

    ● Memento Pattern:<br>
        -Originator: InventoryImpl.java
        -CareTaker: BookInventory.java
        -Memento: InventoryMeneto.java

    ● Command Pattern:
        -Command.java
        -AddBookCommand.java
        -AddMultipleCopyCommand.java
        -ChangeBookPriceCommand.java
        -SellBook.java
        -SellMultipleCopyCommand.java
