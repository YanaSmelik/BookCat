package com.bookcatalogue.BookCat.domain;

import com.bookcatalogue.BookCat.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Data Access Object for Book model.
@Component //for Spring to create a Bean of this class
public class BookDAO implements DAO<Book> {

    private List<Book> books = new ArrayList<>();
    private static int BOOKS_COUNT;

    public BookDAO() {
        //for testing purposes
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", ++BOOKS_COUNT));
        books.add(new Book("Pride and Prejudice", "Jane Austen", ++BOOKS_COUNT));
    }

    @Override
    public Optional<Book> get(int id) {
       return Optional.ofNullable(books.get(id));
        //TODO decide whether to stick to Optional
        // return books.stream().filter(book -> book.getId() == id).findAny().orElse(null);

    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public void update(Book book, String[] parameters) {
        book.setTitle(Objects.requireNonNull(parameters[0], "Title cannot be empty"));
        book.setAuthor(Objects.requireNonNull(parameters[1], "Author cannot be empty"));
        book.setId(books.size() - 1);
        books.add(book);
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
    }
}
