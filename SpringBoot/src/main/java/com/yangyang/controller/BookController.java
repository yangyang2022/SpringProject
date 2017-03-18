package com.yangyang.controller;

import com.yangyang.dao.BookRepo;
import com.yangyang.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller@RequestMapping("/book")
public class BookController {

    private BookRepo bookRepo;

    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/{reader}")
    public String readerBooks(@PathVariable("reader") String reader, Model model){
        List<Book> bookList = bookRepo.findByReader(reader);
        if(bookList != null){
            model.addAttribute("books",bookList);
        }
        return "readingList";
    }
    @PostMapping("/{reader}")
    public String addToBookList(@PathVariable("reader")String reader,Book book){
        book.setReader(reader);
        bookRepo.save(book);
        System.out.println("hello world");
        return "redirect:/book/{reader}";
    }
}
