package com.yangyang.hibernate.dao;

public interface IBookShopDao {

    int findBookPriceByISBN(String isbn);

    //book store -1
    void updateBookStore(String isbn);

    void updateUserAccount(String username,int price);
}
