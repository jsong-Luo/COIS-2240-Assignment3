package Assignement3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
       //Add displayTransactionHistory method
	public void displayTransactionHistory() {
		System.out.println(" Transaction History ");
		File file = new File("transactions.txt");
		if(!file.exists()) {
			System.out.println(" The file not exist. No transaction history found.");
			return;
		}
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("file"));
			boolean hasTransactions = false;
			String line;
			while((line = reader.readLine())!= null) {
			     System.out.println(line);
			     hasTransactions = true;
			}
			if(!hasTransactions) {
				System.out.println("No Transactions Found.");
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}