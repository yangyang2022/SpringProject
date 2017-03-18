package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@RestController @ComponentScan(basePackages = "com.yangyang")
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    @RequestMapping("/hellos")
    public String hello(){
        return "just a test ... ";
    }

    //@Bean
    //public HttpMessageConverters fastJsonMessageConverter(){
    //    //use fastjson to converter data
    //    FastJsonHttpMessageConverter fastconverter  = new FastJsonHttpMessageConverter();
    //    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    //    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
    //    fastconverter.setFastJsonConfig(fastJsonConfig);
    //    System.out.println("add fast json ... ");
    //    return new HttpMessageConverters((HttpMessageConverter<?>) fastconverter);
    //}
    //@Override
    //public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    //    //use fastjson to converter data
    //    FastJsonHttpMessageConverter fastconverter  = new FastJsonHttpMessageConverter();
    //    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    //    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
    //    fastconverter.setFastJsonConfig(fastJsonConfig);
    //    converters.add(fastconverter);
    //    System.out.println("add fastjson ... ");
    //}

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);

    }
}
