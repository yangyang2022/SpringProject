package com.yangyang.hibernate.model;

import javax.persistence.*;

@Entity@Table(name = "t_account")
public class Account {
    private Integer id;
    private String username;
    private int balance;

    public Account() {
    }

    public Account(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
