package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController // Tell us that this is a RestController
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  @Autowired // Dep injection, auto instantiate a class for us without us having to say to create a class
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  // Post a book to the server, return a book object
  // @auth private
  @PostMapping(consumes = "application/json", produces = "application/json")
  public Book postBook(@RequestBody Book book) {
    System.out.println(book);
    return bookService.postBook(book);
  }

  // Get all books
  // @auth public
  @GetMapping
  public java.util.List<Book> getBooks() {
    return bookService.getBooks();
  }

  // Get book by id
  // @auth public
  @GetMapping(value = "/{id}")
  public Optional<Book> getBookById(@PathVariable Long id) {
    // find and Get book
    // no Book? return responsestatusExeption
    Optional<Book> bookById = bookService.getBookById(id);

    // below not necessary but was fun to mess around with.
    try {
      if (bookById.isEmpty()) {
        throw new Exception("No Book Found");
      }
      return bookById;
    } catch (Exception e) {
      System.out.println(e.toString());
      return Optional.empty();
    }
  }


  // Update a book
  // @auth private
  /*
     get book id,
     get user update input
     update input
     book exist?
     if do, update book
    */
  @PutMapping(value = "/{id}")
  public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
    return bookService.updateBook(id, book);
  }

  @DeleteMapping(value = "/{id}")
  public String deleteBook(@PathVariable Long id) {
    return bookService.deleteBook(id);
  }


//  @org.springframework.web.bind.annotation.PostMapping("/books/:id")
//  public com.example.demo.book.Book Book();
}

