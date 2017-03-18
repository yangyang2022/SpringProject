package java;

import com.yangyang.model.User;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by syy on 2017/3/12.
 */
public class TestFastJson {

    @Test
    public void testJson() {
        //User user = new User(1,"shen", "yangyang", LocalDate.now());
        //String userJson = JSON.toJSONString(user);
        //System.out.println(userJson);
        //
        //User user1 = JSON.parseObject(userJson, User.class);
        //System.out.println(user1);

    }

    @Test
    public void testJson2() {
        List<User> users = Arrays.asList(
                new User(1,"shen1","yang1",LocalDate.now().minusYears(1)),
                new User(2,"shen2","yang2",LocalDate.now().minusYears(2)),
                new User(3,"shen3","yang3",LocalDate.now().minusYears(3)),
                new User(4,"shen4","yang4",LocalDate.now().minusYears(4))
        );
        //String userJson = JSON.toJSONString(users);
        //System.out.println(userJson);
        //
        //List<User> userList = JSON.parseArray(userJson,User.class);
        //System.out.println(userList);

    }
}
