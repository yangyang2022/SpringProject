package com.yangyang.dao;

import com.yangyang.model.Spittle;

import java.util.List;

/**
 * Created by syy on 2017/2/23.
 */
public interface ISpittleRepo {
    List<Spittle> findSpittles(int max,int count);
}
