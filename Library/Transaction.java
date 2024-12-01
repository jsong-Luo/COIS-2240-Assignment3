package Assignement3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    	//set static instance variables
	private static Transaction instance;
	
	//private variables
	private boolean borrowBook;
	private String currentDateTime;
	
	//private constructor
	private Transaction() {
		this.borrowBook = false;
		this.currentDateTime = getCurrentDateTime();
		returnBook(null, null);
	}

    	public static Transaction getInstance() {
		if(instance == null) {
			instance = new Transaction();
		}
		return instance;
	}

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            saveTransaction(transactionDetails);
            System.out.println(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            saveTransaction(transactionDetails);
            System.out.println(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
        // Set a saveTransaction method
    private void saveTransaction(String transactionDetails){
    	BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("transactions.txt"));
		    writer.write(transactionDetails);
    	    writer.newLine();   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}    	
    }
}