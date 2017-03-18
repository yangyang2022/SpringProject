package com.yangyang.model;

import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class ShopService {

    @Autowired
    private ShoppingCart shoppingCart;

    //注意这里 shopService是一个singleton,而shoppingCart是一个session作用域
    //shopService会被立即加载而此时shoppingCart不存在...所用用代理
    //代理暴露的接口一样,当需要使用时会被委托在session作用域中查找真实对象
    //所以也会出现冲突问题

    //在xml中配置需要加入 <aop:scope-proxy proxy-target-class = false />
    //xml默认的代理类
}
