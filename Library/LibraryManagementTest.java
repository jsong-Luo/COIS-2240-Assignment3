package Assignement3;

import static org.junit.Assert.*;

import java.lang.reflect.Member;

import org.junit.Test;

import Assignement3.Transaction;
import Assignment3.Book;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
public class LibraryManagementTest {

	//Test book ID
	@Test
	public void testBookId() throws Exception {
		
		Book newBook1 = new Book(100, "Programming");
		Book newBook2 = new Book(210, "Test2");
		Book newBook3 = new Book(999, "Test3");
        Book newBook4 = new Book(100, "Test4");
		
        // Assertions to validate the results
        assertEquals(100, newBook1.getId());
        assertEquals("Programming", newBook1.getTitle());

        assertEquals(210, newBook2.getId());
        assertEquals("Test2", newBook2.getTitle());

        assertEquals(999, newBook3.getId());
        assertEquals("Test3", newBook3.getTitle());
        
        assertTrue(newBook4.isValidId(100));
        
        assertFalse(newBook4.isValidId(1000));
        //assertEquals("Test4", newBook4.getTitle());
       
        assertFalse(newBook4.isValidId(50));
	}
    	//Borrow/Return Validation
	@Test
	public void testBrrowReturn() throws Exception {
		//Instantiate a Book object and a Member object.
		Book newBook = new Book(100, "Programming");
		Member newMember = new Member(1111,"George");
		
		//Use proper assertion to ensure that the book is available
		assertTrue(newBook.isAvailable());
		
		//Retrieve Transaction instance
		Transaction transaction = Transaction.getInstance();
		
		//call the borrowBook, borrow the book. Test borrowBook method and test book is not available after.
		boolean borrowBook = transaction.borrowBook(newBook, newMember);
		assertTrue(borrowBook);
		assertFalse(newBook.isAvailable());
		
		//Borrow the book again
		boolean borrowBookAgain = transaction.borrowBook(newBook, newMember);
		assertFalse(borrowBookAgain);
		
		//Return the book, and verify if it's successful by check its availability
		boolean returnBook = transaction.returnBook(newBook, newMember);
		assertTrue(returnBook);


		
		//Return the book again.
		boolean returnBookAgain = transaction.returnBook(newBook, newMember);
		assertFalse(returnBookAgain);

		
	}
 	//Question3 Singleton Validation
     @Test
     public void testSingletonTransaction() throws Exception {
         //return the constructor of the Transaction class
         Constructor<Transaction> constructors = Transaction.class.getDeclaredConstructor();
         //Get the modifier of the constructor
         int modifiers = constructors.getModifiers();
         assertTrue(Modifier.isPrivate(modifiers));
         assertEquals("Constructor is not private!", Modifier.PRIVATE, modifiers);
         System.out.println("Constructor modifier: " + modifiers);
     }   


}
