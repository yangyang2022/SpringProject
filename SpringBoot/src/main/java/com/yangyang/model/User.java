package com.yangyang.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity@Table(name = "t_user")
public class User {
    private Integer id;
    private String firstname;
    private String lastname;

    private LocalDate birth;

    public User() {
    }

    public User(String firstname, String lastname, LocalDate birth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
    }

    public User(Integer id, String firstname, String lastname, LocalDate birth) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
    }

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
