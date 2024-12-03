package Assignement3;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryManagementTest {

	//Test book ID
	@Test
	public void testBookId() throws Exception {
		
		Book newBook1 = new Book(100, "Programming");
		Book newBook2 = new Book(210, "Test2");
		Book newBook3 = new Book(999, "Test3");
		Book newBook4 = new Book(1000, "Test4");
		Book newBook5 = new Book(50, "Test5");
		
        // Assertions to validate the results
        assertEquals(100, newBook1.getId());
        assertEquals("Programming", newBook1.getTitle());

        assertEquals(210, newBook2.getId());
        assertEquals("Test2", newBook2.getTitle());

        assertEquals(999, newBook3.getId());
        assertEquals("Test3", newBook3.getTitle());
        
        assertEquals(1000, newBook4.getId());
        assertEquals("Test4", newBook4.getTitle());
       
        assertEquals(50, newBook5.getId());
        assertEquals("Test5", newBook5.getTitle());
	}

}
