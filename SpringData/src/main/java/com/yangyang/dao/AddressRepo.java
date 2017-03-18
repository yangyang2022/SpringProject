package com.yangyang.dao;

import com.yangyang.model.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by syy on 2017/3/10.
 */
public interface AddressRepo extends CrudRepository<Address,Integer> {
}
