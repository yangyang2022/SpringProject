package com.yangyang.dao;

import org.springframework.beans.factory.annotation.Value;

public interface RenamedProperty {

    String getLastname();

    @Value("#{(target.lastname == null || target.lastname.empty) ? null : '********'}")
    String getName();
}
