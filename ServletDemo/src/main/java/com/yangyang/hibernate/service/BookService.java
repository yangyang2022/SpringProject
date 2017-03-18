package com.yangyang.hibernate.service;

import com.yangyang.hibernate.dao.IBookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by syy on 2017/2/21.
 */

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookShopDao bookShopDao;

    @Override
    public void purches(String username, String isbn) {

        int price = bookShopDao.findBookPriceByISBN(isbn);

        bookShopDao.updateBookStore(isbn);

        bookShopDao.updateUserAccount(username,price);

    }
}
