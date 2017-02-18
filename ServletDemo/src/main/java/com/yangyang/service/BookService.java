package com.yangyang.service;

import com.yangyang.model.Book;
import com.yangyang.model.Category;

import java.util.List;

/**
 * Created by syy on 2017/2/17.
 */
public interface BookService {
    List<Category> getAllCategories();
    Category getCategory(int id);
    List<Book> getBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(long id);
    long getNextId();

    boolean delete(long id);

}
