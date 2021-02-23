package com.bookcatalogue.BookCat.controllers;

import com.bookcatalogue.BookCat.domain.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    private BookDAO bookDAO;

    @Autowired // for injection, optional annotation
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()  // controller's endpoint: "/books"
    public String getAll(Model model){
        // get all books from DAO and display them
        model.addAttribute("books", bookDAO.getAll()); //arrayList of Books
        return "books/getAll";
    }

    @GetMapping("/{id}") //id from the url will be given to the param of the method: "/books/id"
    public String showBook(@PathVariable("id") int id, Model model){
        // return one book by id from DAO and display it
        model.addAttribute("book", bookDAO.get(id));
        return "books/showBook";
    }

}
