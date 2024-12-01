package Assignement3;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import Assignment3.Book;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    // Add a new member to the library. Change method to boolean.
    public boolean addMember(Member member) {
        Member memberFind = findMemberById(member.getId());
        if(memberFind == null){
        	members.add(member);
        	return true;//If member not existed in list, add member and return true.
        	}
        else{
        	return false;
        	}
    }
    
    // Add a new book to the library. Change method to boolean
    public boolean addBook(Book book) {
    	Book bookFind = findBookById(book.getId());
    	if(bookFind == null) {
    		books.add(book);
    		return true;//if book doesn't exist in the list, add book and return true.
    	}
    	else {
    		return false;
    	}
    }
    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
}
