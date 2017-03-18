import com.yangyang.model.User;
import com.yangyang.util.NameUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestSpringMongo {

    @Resource
    private MongoTemplate mt ;

    private static final String collectionName = "users";

    private void printCollections(){
        //query
        List<User> userList = mt.find(new Query(),User.class,collectionName);
        System.out.println("size: "+userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testConnection() {

        //add
        //User user = new User("myu101", "yangyang", "33", "wuhu");
        //mt.insert(user,collectionName);

        //update
        //Query query = new Query(new Criteria("name").is("yangyang"));
        //mt.updateMulti(query,
        //        Update.update("name","shenyangyang"),
        //        User.class,collectionName);


        //remove name=shenyangyang and age [60,100]
        Query removeQuery = new Query(new Criteria().orOperator(
                new Criteria("name").regex("/yang/"),
                new Criteria().andOperator(new Criteria("age").gte(60),new Criteria("age").lte(100))
        ));

        //mt.remove(removeQuery,collectionName);
        List<User> userList = mt.find(removeQuery, User.class, collectionName);
        System.out.println("size: "+userList.size());
        System.out.println(userList);

        //printCollections();

    }

    @Test
    public void testInsert() {
        Random random = new Random();
        List<String> names = NameUtil.getNames(10000);
        names.forEach(e->mt.insert(new User("userid",e,random.nextInt(100)),collectionName));
    }
}
