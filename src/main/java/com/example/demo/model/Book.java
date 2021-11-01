package com.example.demo.model;

import java.util.Date;

//@javax.persistence.Entity
@lombok.Data
@lombok.ToString
public class Book {
  private Date createdAt = new Date();
  private Date updatedAt;
  private @javax.persistence.Id
  @javax.persistence.GeneratedValue
  Long id;
  private String author;
  private String description;
  private String publisher;
  private String book_img;
  private String title;
  private boolean isCheckedOut;
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
