package com.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Trangel implements ApplicationContextAware,BeanNameAware,InitializingBean,DisposableBean {

    private ApplicationContext context ;

    private String beanName ;

    public void drawing(){
        System.out.println("rangel drawing ... ");
    }

    public void printContext(){

        System.out.println(context.getApplicationName() + " : " + context.getDisplayName() + " : " + context.getId());
        System.out.println(context.getParent() + " : " + context.getStartupDate() + " : " +
                (context.getBean("trangel", Trangel.class)));


    }
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("benaName: "+name);
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ... ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(beanName+" is destroy ... ");
    }
}
