package com.bookcatalogue.BookCat.domain;

import java.util.List;
import java.util.Optional;

// Data Access Object interface
public interface DAO<T> {

    // Basic CRUD operations
    Optional<T> get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] parameters);

    void delete(T t);
}
