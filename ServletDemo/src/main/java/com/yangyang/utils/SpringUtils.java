package com.yangyang.utils;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

class User{
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
public class SpringUtils {

    @Test
    public void testDemo1() {
        User user = new User();
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);
        beanWrapper.setPropertyValue("username","yangyang");
        System.out.println(user.getUsername());

        String name = "com.yangyang.spring.helloworld";
        String[] strings = StringUtils.commaDelimitedListToStringArray(name);

        System.out.println("length: "+strings.length);

        for(String s:strings) System.out.println(s);
    }

    @Test
    public void testDemo2() {
    }
}
