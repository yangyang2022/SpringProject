package com.yangyang.service;

import com.yangyang.model.User;

import java.util.List;

public interface IUserService {

    void save(User user);

    void delete(int id);

    void update(User user,int id);

    User findByLastname(String lastname);

    List<User> findAll();
}
