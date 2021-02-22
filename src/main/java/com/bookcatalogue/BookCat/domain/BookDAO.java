package com.bookcatalogue.BookCat.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Data Access Object for Book
public class BookDAO implements DAO<Book> {

    private List<Book> books = new ArrayList<>();

    public BookDAO() {
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 2));
    }

    @Override
    public Optional<Book> get(int id) {
        return Optional.ofNullable(books.get(id));
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
