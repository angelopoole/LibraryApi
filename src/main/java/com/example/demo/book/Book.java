package com.example.demo.book;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
//@RequiredArgsConstructor
@lombok.ToString
@Entity
@Table(name = "BOOKS")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BOOK_ID")
  public Long id;

  @Column(name = "CREATED_AT")
  private Date createdAt = new Date();

  @Column(name = "UPDATED_AT")
  private Date updatedAt;

  @Column(name = "AUTHOR")
  private String author;

  @Column(name = "DESCRIPTION", length = 2000)
  private String description;

  @Column(name = "PUBLISHER")
  private String publisher;

  @Column(name = "BOOK_IMAGE")
  private String book_img;

  @Column(name = "TITLE")
  private String title;

  //  @JsonProperty
  @Column(name = "IS_CHECKED_OUT")
  private Boolean isCheckedOut = false;

  @Column(name = "REVIEW_AVERAGE")
  private int reviewAverage;

  // ArrayList of reviews when I make that model

  public Book() {
  }

  public Book(
          String author,
          String description,
          String publisher,
          String book_img, String title, boolean isCheckedOut, int reviewAverage) {
    this.author = author;
    this.description = description;
    this.publisher = publisher;
    this.book_img = book_img;
    this.title = title;
    this.isCheckedOut = isCheckedOut;
    this.reviewAverage = reviewAverage;
  }

  public Book(java.util.Date createdAt,
              java.util.Date updatedAt,
              Long id,
              String author,
              String description,
              String publisher,
              String book_img,
              String title,
              boolean isCheckedOut, int reviewAverage) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.id = id;
    this.author = author;
    this.description = description;
    this.publisher = publisher;
    this.book_img = book_img;
    this.title = title;
    this.isCheckedOut = isCheckedOut;
    this.reviewAverage = reviewAverage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Book book = (Book) o;
    return id != null && Objects.equals(id, book.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}

//export interface Book {
//  createdAt: string;
//  updatedAt: string;
//  id: number;
//  author: string;
//  description: string;
//  publisher: string;
//  book_image: string;
//  title: string;
//  isCheckedOut: boolean;
//  reviewAverage: null | number;
//  reviews: Review[];
//}


//export interface Review {
//  createdAt: string;
//  updatedAt: string;
//  id: number;
//  description: string;
//  rating: number;
//  reviewer: number;
//}
//
