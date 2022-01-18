package com.training.libraryservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookid;

    private String title;

    private String genre;

    private String author;

    private String isbn;

    private double price;

    public Book() {
    }

    public Book(Long bookid, String title, String genre, String author, String isbn, double price) {
        this.bookid = bookid;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                bookid.equals(book.bookid) &&
                title.equals(book.title) &&
                Objects.equals(genre, book.genre) &&
                author.equals(book.author) &&
                isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookid +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", isbnno='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }
}
