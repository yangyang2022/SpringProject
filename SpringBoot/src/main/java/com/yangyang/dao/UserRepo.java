package com.yangyang.dao;

import com.yangyang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByLastname(String lastname);

    User findById(Integer id);

    @Query("select u from User u where u.lastname=?1")
    User findByName(String lastname);
}
