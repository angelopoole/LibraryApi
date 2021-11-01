package com.example.demo.BookService;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

//Tell us that this is a component(Service)
@Service
public class BookService {


  public java.util.List<com.example.demo.model.Book> getBooks() {
    return java.util.List.of(
            new Book("angelo", "really good book", "some publisher", "somebookimg", "StunningRevelations", true, 5),
            new Book("angelo", "really good book", "some publisher", "somebookimg", "StunningRevelations", true, 5)
    );
  }

  public List<Book> postBook(Book book) {
    System.out.println(book);
    // I can change the book parameters based on the users input here.
    // then we'd life to defer the posting of the data to the repository
    return List.of(book);
  }

  public void deleteBook(Book book) {

  }

  public Book getBookById(int id) {
    System.out.println(id);
    return new Book();
  }


}

