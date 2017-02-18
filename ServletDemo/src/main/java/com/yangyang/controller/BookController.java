package com.yangyang.controller;

import com.yangyang.model.Book;
import com.yangyang.model.Category;
import com.yangyang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/input")
    public String inputBook(Model model){
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("cats",categories);
        model.addAttribute("book",new Book());
        return "bookAddFrom";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id")int id,Model model){
        bookService.delete(id);
        System.out.println("delete id: "+id+" size: "+bookService.getBooks().size());
        model.addAttribute("books",bookService.getBooks());
        return "redirect:/book/list";
    }
    @GetMapping(value = "/list")
    public String list(Model model){
        model.addAttribute("books",bookService.getBooks());
        return "BookListForm";
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable("id")int id){
        model.addAttribute("cats",bookService.getAllCategories());
        model.addAttribute("book",bookService.get(id));
        return "BookEditForm";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book")@Valid Book book, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("cats",bookService.getAllCategories());
            return "bookAddFrom";
        }
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book/list";
    }

    @PostMapping("/update")
    public String update(Book book){
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/book/list";
    }
}
