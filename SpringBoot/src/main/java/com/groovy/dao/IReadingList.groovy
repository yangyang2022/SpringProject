package com.groovy.dao

import com.groovy.model.Book

interface IReadingList {
    List<Book> findByReader(String reader)
    void save(Book book)
}