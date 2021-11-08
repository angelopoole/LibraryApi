package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

//Tell us that this is a component(Service)
@Service
public class BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }


  public Book postBook(Book book) {
    System.out.println(book);
    // I can change the book parameters based on the users input here.
    // then we'd life to defer the posting of the data to the repository here
    bookRepository.save(book);
    return book;
  }


  public Optional<Book> getBookById(Long id) {
    try {
      Optional<Book> foundBook = bookRepository.findById(id);
      if (foundBook.isPresent()) {
        System.out.println(foundBook);
        return foundBook;
      } else {
        throw new Exception("No Book here");
      }
    } catch (Exception e) {
      System.err.println(e);
      System.err.println("There is no BOOK here!!!!!!!!");
      return Optional.empty();
    }
  }

  public List<Book> getBooks() {
    Iterable<Book> iterable = bookRepository.findAll();
//    Stream.of(iterable).forEach(book -> System.out.println(book)); // This also works
//    System.out.println(Stream.of(iterable).toList()); // This also works
//    return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    return StreamSupport.stream(iterable.spliterator(), false).toList(); // This works

  }

  // ------------
  public Book updateBook(Long id, Book newBook) {
    Optional<Book> existingBook = bookRepository.findById(id);

    if (existingBook.isEmpty()) {
      return null;
    }

    Book bookToUpdate = existingBook.get();

    System.out.println(newBook.toString());

    if (newBook.getAuthor() != null) {
      bookToUpdate.setAuthor(newBook.getAuthor());
    }
    if (newBook.getDescription() != null) {
      bookToUpdate.setDescription(newBook.getDescription());
    }
    if (newBook.getPublisher() != null) {
      bookToUpdate.setPublisher(newBook.getPublisher());
    }
    if (newBook.getBook_img() != null) {
      bookToUpdate.setBook_img(newBook.getBook_img());
    }
    if (newBook.getTitle() != null) {
      bookToUpdate.setTitle(newBook.getTitle());
    }
    if (newBook.getReviewAverage() != 0) {
      bookToUpdate.setReviewAverage(newBook.getReviewAverage());
    }
    if (newBook.getIsCheckedOut() != null) {
      bookToUpdate.setIsCheckedOut(newBook.getIsCheckedOut());
    }

    bookRepository.save(bookToUpdate);

    return bookToUpdate;

  }

  public String deleteBook(Long id) {
    Optional<Book> bookToDelete = bookRepository.findById(id);

    if (bookToDelete.isPresent()) {
      bookRepository.deleteById(id);
      return "Successfully deleted";
    }

    return "Book Not Found";


  }


}

