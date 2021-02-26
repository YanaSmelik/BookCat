package com.bookcatalogue.BookCat.controllers;

import com.bookcatalogue.BookCat.domain.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping //("/books")
public class BooksController {

    private BookDAO bookDAO;

    @Autowired // for injection, optional annotation
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /*@GetMapping()  // controller's endpoint: "/books"
    public String getAll(Model model) {
        // get all books from DAO and display them
        model.addAttribute("books", bookDAO.getAll()); //arrayList of Books
        return "books/getAll";
    }*/

    //@GetMapping("/{id}") //id from the url will be given to the param of the method: "/books/id"
    @GetMapping(path = {"/", "hello"})
    //public String showBook(@PathVariable("id") int id, Model model){
    public String showBook(Model model, @RequestParam(value = "id") int id) {
        // return one book by id from DAO and display it
        model.addAttribute("id", bookDAO.get(id));
        return "hello";
    }

}
