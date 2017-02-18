import com.yangyang.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestConnection {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jt;

    @Resource
    private DataSource dataSource;

    @Schedules({
            @Scheduled(cron = "0 0 12 * * ?"),
            @Scheduled(cron = "0 0 18 * * ?")
    })
    @Test
    public void testConnection() throws SQLException {
        String sql = "select username,password from user where id<?";
        List<User> users = jt.query(sql,
                (PreparedStatement ps) -> ps.setInt(1, 5),
                (rs, rowNum) ->
                        new User(rowNum,rs.getString("username"), rs.getString("password")));

        System.out.println(users);

    }
}
