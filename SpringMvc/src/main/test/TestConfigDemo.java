import com.yangyang.concert.ICalcu;
import com.yangyang.concert.IPerformance;
import com.yangyang.model.BlankDisc;
import com.yangyang.model.MagicBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {BeanConfig.class})
@ContextConfiguration("/beans.xml")
public class TestConfigDemo {

    @Autowired
    private ApplicationContext ctx ;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BlankDisc blankDisc;

    @Autowired
    private IPerformance performance;

    @Autowired
    private ICalcu calcu;

    @Test
    public void testDemo1() throws SQLException {

        System.out.println("key: "+ctx.getEnvironment().containsProperty("magic"));

        MagicBean magicBean = ctx.getBean(MagicBean.class);
        String str = magicBean.sayHello("yangyang");
        System.out.println(str);

    }

    @Test
    public void testBlankDisc() {
        System.out.println(blankDisc);
    }

    @Test
    public void testPerformance() {
        performance.perform();
        performance.seat("yangyang");
    }

    @Test
    public void testCalcu() {
        System.out.println(calcu.add(1, 2));

    }
}
