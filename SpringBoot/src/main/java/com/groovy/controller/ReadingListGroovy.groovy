package com.groovy.controller

import com.groovy.model.Book
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

class ReadingListGroovy {

//    @Autowired
//    IReadingList readRepo

    @GetMapping("/{reader}")
    def readerBooks(@PathVariable("reader")String reader,Model model){
        println("====================start ======================")
        List<Book> readingList = Book.findAllByReader(reader)
        println("======================end ====================== ")
        if(readingList){
            model.addAttribute("books",readingList)
        }
        "readingList"
    }
    @PostMapping("/{reader}")
    def addReaderBook(@PathVariable("reader")String reader,Book book){
        Book.withTransaction {
            book.reader = reader
            book.save()
        }

        "redirect:/groovy/{reader}"
    }
}
