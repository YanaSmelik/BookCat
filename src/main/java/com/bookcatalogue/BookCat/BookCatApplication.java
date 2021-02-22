package com.bookcatalogue.BookCat;

import com.bookcatalogue.BookCat.domain.Book;
import com.bookcatalogue.BookCat.domain.BookDAO;
import com.bookcatalogue.BookCat.domain.DAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class BookCatApplication {
 private static DAO<Book>  bookDAO;
	public static void main(String[] args) {
		//SpringApplication.run(BookCatApplication.class, args);

		bookDAO = new BookDAO();
		Book book1 = getBook(1);
		System.out.println("Title: " + book1.getTitle());
		System.out.println("Author: " + book1.getAuthor());
	}

	private static Book getBook(int id){
		Optional<Book> book = bookDAO.get(id);
		return book.orElseGet(()->new Book("unknown", "unknown"));
	}

}
