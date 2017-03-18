package com.yangyang.service;

import com.yangyang.dao.UserRepo;
import com.yangyang.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepo userRepo;

    User findByName(String lastname){return userRepo.findByLastname(lastname);}

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Transactional
    @Override
    public void delete(int id) {
        userRepo.delete(id);
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        User loadUser = userRepo.findById(id);
        BeanUtils.copyProperties(user,loadUser);
        userRepo.save(loadUser);
    }

    @Override
    public User findByLastname(String lastname) {
        return userRepo.findByName(lastname);
    }

    public long getUserCount(){return userRepo.count();}


}
