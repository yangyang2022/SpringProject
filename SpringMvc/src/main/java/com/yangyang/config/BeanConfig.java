package com.yangyang.config;

import com.yangyang.model.BlankDisc;
import com.yangyang.model.MagicBean;
import com.yangyang.model.MagicExistCondition;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.yangyang")
@PropertySource("classpath:/app.properties")
public class BeanConfig {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/hibernate5?useUnicode=true&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "123123";
    private static final String drivername = "com.mysql.jdbc.Driver";


    @Autowired
    private Environment environment;

    private String getEnv(String value){
        return environment.getProperty(value);
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(drivername);
        return dataSource;
    }

    @Bean@Conditional(MagicExistCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }

    //@Bean
    public BeanAddProperty beanAddProperty(){
        return new BeanAddProperty();
    }

    //@Bean
    public BlankDisc blankDisc1(){
        return new BlankDisc();
    }
}
