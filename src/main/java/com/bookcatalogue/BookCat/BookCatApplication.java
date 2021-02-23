package com.bookcatalogue.BookCat;

import com.bookcatalogue.BookCat.models.Book;
import com.bookcatalogue.BookCat.domain.BookDAO;
import com.bookcatalogue.BookCat.domain.DAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class BookCatApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookCatApplication.class, args);


	}

}
