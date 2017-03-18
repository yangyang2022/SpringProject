package com.yangyang.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity@Table(name = "t_person")
@NamedStoredProcedureQuery(name = "Person.plus1", procedureName = "plus1inout", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "age", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Integer.class) })
public class Person {

    private Integer id;
    private String lastname;
    private Integer age;
    private String email;
    private LocalDate birth;

    @CreatedDate
    private Address address;

    public Person() {
    }

    public Person(String lastname, String email, LocalDate birth, Address address) {
        this.lastname = lastname;
        this.email = email;
        this.birth = birth;
        this.address = address;
    }

    public Person(String lastname, Integer age, String email, LocalDate birth, Address address) {
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.birth = birth;
        this.address = address;
    }

    public Person(Integer id, String lastname, String email, LocalDate birth) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.birth = birth;
    }

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @LazyCollection(LazyCollectionOption.EXTRA)
    @ManyToOne@JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", address=" + address +
                '}';
    }
}
