package com.yangyang.dao;


import com.yangyang.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.stream.Stream;

public interface PersonRepository extends
        JpaRepository<Person,Integer>,JpaSpecificationExecutor<Person>,PersonDao {

    Person getByLastname(String lastname);

    @Query("select p from Person p where p.id=(select p2.id from Person p2)")
    Person getMaxIdPerson();

    //take params
    //@Query("select p from Person p where p.lastname=?1 and p.email=?2")
    //Person getPerson(String lastname,String email);

    @Query("select p from Person p where p.lastname=:lastname and p.email=:email")
    Person getPerson(@Param("lastname") String lastname, @Param("email") String email);

    //param like
    //@Query("select p from Person p where p.lastname like %:lastname% or p.email like %:email%")
    @Query("select p from Person p where p.lastname like %?1% or p.email like %?2%")
    List<Person> likeParam(String lastname,String email);

    //native sql serach
    @Query(value = "select count(id) from t_person",nativeQuery = true)
    long getCount();

    @Modifying //注意jpql不支持insert 操作...
    @Query("update Person p set p.email=:email where p.id=:id")
    void updatePersonEmail(@Param("id") Integer id,@Param("email") String email);


    List<Person> findByLastnameIgnoreCase(String lastname);

    //not support
    @Query("select p from Person p")
    Stream<Person> findPersons();

    //@Async
    //Future<Person> findByLastname(String lastname);

    //@Async
    //CompletableFuture<Person> findByLastname(String lastname);
    //
    //@Async
    //ListenableFuture<Person> findByLastname(String lastname);

    @Query("select p from Person p where p.lastname=?1 ")
    List<Person> findBySpel(String lastname);

    //NoAddress findByLastname(String lastname);

    @Lock(LockModeType.READ)
    RenamedProperty findByLastname(String lastname);

    @Procedure(name = "Person.plus1")
    Integer explicitlyNamedPlus1inout(Integer age);




}
