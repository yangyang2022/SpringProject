package java;

import com.Application;
import com.yangyang.model.User;
import com.yangyang.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestSpringBoot {

    @Resource
    private IUserService userService;

    @Test
    public void testUserRepo() {

        User user = new User("helloTest","worldTest", LocalDate.now());

        //userService.save(user);
        //
        //User userBylastname = userService.findByLastname(user.getLastname());
        //System.out.println(userBylastname);

        user.setId(3);
        userService.update(user,3);
        System.out.println(userService.findByLastname("worldTest"));

    }
}
