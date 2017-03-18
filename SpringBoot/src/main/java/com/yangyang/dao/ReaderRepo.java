package com.yangyang.dao;

import com.yangyang.security.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by syy on 2017/3/15.
 */
public interface ReaderRepo extends JpaRepository<Reader,String> {

}
