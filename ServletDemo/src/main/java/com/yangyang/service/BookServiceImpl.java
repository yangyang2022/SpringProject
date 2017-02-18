package com.yangyang.service;

import com.yangyang.model.Book;
import com.yangyang.model.Category;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private List<Category> categories;
    private List<Book> books;

    public BookServiceImpl(){
        categories = new ArrayList<>();
        Category category1 = new Category(1,"Computing");
        Category category2 = new Category(2, "Travel");
        Category category3 = new Category(3, "Health");

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        books = new ArrayList<>();
        books.add(new Book(1l,"2011080301","Servlet & JSP",category1,"Budi", LocalDate.of(2016,12,25)));
        books.add(new Book(2l,"2011080302","Think in java",category1,"Bruce Ekel",LocalDate.of(2015,5,12)));
    }
    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category getCategory(int id) {
        return categories.stream().filter(e->e.getId() == id).findFirst().get();
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        int bookCount = books.size();
        for (int i = 0; i < bookCount; ++i) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                return book;
            }
        }
        System.out.println("update false ... ");
        return book;
    }

    @Override
    public Book get(long id) {
        return books.stream().filter(e->e.getId() == id).findFirst().get();
    }

    @Override
    public long getNextId() {
        //need to be locked
        long id = 0l;
        for(Book book : books){
            if(book.getId() > id) id = book.getId();
        }
        return id+1;
    }

    @Override
    public boolean delete(long id) {
        return books.remove(new Book(id));
    }
}
