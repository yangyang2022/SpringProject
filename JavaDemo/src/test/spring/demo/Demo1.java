package spring.demo;

import com.spring.model.Trangel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class Demo1 {

    @Resource
    private ApplicationContext applicationContext;

    @Test
    public void testDemo1() {

        Trangel trangel = applicationContext.getBean("trangel", Trangel.class);
        trangel.drawing();
        //trangel.printContext();


    }
}
