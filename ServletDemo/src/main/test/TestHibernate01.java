import com.yangyang.hibernate.service.IBookService;
import com.yangyang.hibernate.service.ICasher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestHibernate01 {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICasher casher;

    @Test
    public void testConnect() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testBookShopService() {

        //bookService.purches("aa","1001");
        casher.check("aa", Arrays.asList("1001","1002"));

    }
}
