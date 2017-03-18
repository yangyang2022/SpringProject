package com.yangyang.hibernate.dao;

import com.yangyang.hibernate.exception.BookStockException;
import com.yangyang.hibernate.exception.UserBalanceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDao implements IBookShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    //get current Thread session
    private Session getSession(){return sessionFactory.getCurrentSession();}

    @Override
    public int findBookPriceByISBN(String isbn) {
        String hql = "select b.price from Book b where b.isbn=?";
        return (int) getSession().createQuery(hql).setParameter(0,isbn).uniqueResult();
    }

    @Override
    public void updateBookStore(String isbn) {
        //验证stock是否足够
        if(getStockByBookISBN(isbn) < 0 ) throw new BookStockException("库存不足!!!");

        String hql = "update Book b set b.stock = b.stock -1 where b.isbn=?";
        getSession().createQuery(hql).setParameter(0,isbn).executeUpdate();
    }

    @Override
    public void updateUserAccount(String username, int price) {
        if(getPriceByUsername(username) < price) throw new UserBalanceException("用户余额不足!!!");
        String hql = "update Account a set a.balance=a.balance - ? where a.username=?";
        getSession().createQuery(hql).setParameter(0,price).setParameter(1,username).executeUpdate();
    }
    private int getStockByBookISBN(String isbn){
        String hql = "select b.stock from Book b where b.isbn=?";
        return (int) getSession().createQuery(hql).setParameter(0,isbn).uniqueResult();
    }
    private int getPriceByUsername(String username){
        String hql = "select a.balance from Account a where a.username=?";
        return (int) getSession().createQuery(hql).setParameter(0,username).uniqueResult();
    }
}
