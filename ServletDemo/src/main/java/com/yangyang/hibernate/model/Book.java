package com.yangyang.hibernate.model;

import javax.persistence.*;

@Entity@Table(name = "t_book")
public class Book {
    private Integer id;
    private String bookname;
    private String isbn;
    private int price;
    private int stock;

    public Book() {
    }

    public Book(String bookname, String isbn, int price, int stock) {
        this.bookname = bookname;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
    }

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "book_name")
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
