package com.yangyang.dao;

import com.yangyang.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by syy on 2017/3/14.
 */
public interface BookRepo extends JpaRepository<Book,Long> {

    List<Book> findByReader(String reader);

}
