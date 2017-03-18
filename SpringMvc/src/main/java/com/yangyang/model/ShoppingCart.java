package com.yangyang.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

//@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.INTERFACES)
public class ShoppingCart {
    //如果使用singleton不合理
    //使用prototype那么在某个地方加入商品在另个地方就不能用了
    //最好使用session
}
