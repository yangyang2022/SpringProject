package com.yangyang.hibernate.service;

import java.util.List;

/**
 * Created by syy on 2017/2/21.
 */
public interface ICasher {

    void check(String username, List<String> isbns);

}
