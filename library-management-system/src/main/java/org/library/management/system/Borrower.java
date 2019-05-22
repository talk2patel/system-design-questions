package org.library.management.system;

import java.time.LocalDateTime;
import java.util.List;

public class Borrower extends Person{

	public void requestBook(Book book) {}
	public void returnBook(Book book) {}
	public void payFine(double amount) {}
	public List<Book> findByTitle(String title){ return null;}
	public List<Book> findByAuthorName(String authorName){return null;}
	public List<Book> findBySubject(String subject){return null;}
	public boolean placeOnHoldRequest(Book book, LocalDateTime startDate, LocalDateTime returnDate) {return false;}
}
