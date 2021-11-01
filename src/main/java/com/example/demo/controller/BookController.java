package com.example.demo.controller;

import com.example.demo.BookService.BookService;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController // Tell us that this is a RestController
@RequestMapping("/books")
public class BookController {


  private final com.example.demo.BookService.BookService bookService;

  @Autowired // Dep injection, auto instantiate a class for us without us having to say to create a class
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  // Post a book to the server, return a book object
  @PostMapping(consumes = "application/json", produces = "application/json")
  public List<Book> postBook(@RequestBody Book book) {
    System.out.println(book);
    return bookService.postBook(book);
  }

  //TODO
  // Get all books
  @GetMapping
  public java.util.List<Book> getBooks() {
    return bookService.getBooks();
  }

  //TODO
  // Get book by id
  @GetMapping(value = "/{id}")
  public Book getBookById(@PathVariable int id) {
    return bookService.getBookById(id);
  }


  //TODO
  // Update a book
  @PutMapping
  public Book updateBook() {
    return new Book();
  }


//  @org.springframework.web.bind.annotation.PostMapping("/books/:id")
//  public com.example.demo.model.Book Book();
}

