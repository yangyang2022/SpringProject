package com.yangyang.dao;

import com.yangyang.model.Spittle;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpittleRepo implements ISpittleRepo {

    private List<Spittle> createSpittle(int count){
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            spittles.add(new Spittle((long)i,"Spittle"+i, LocalDateTime.now(),0.1,0.1));
        }
        return spittles;
    }
    @Override
    public List<Spittle> findSpittles(int max, int count) {
        return createSpittle(count);
    }
}
