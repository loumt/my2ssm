package jdbc;

import cn.mt.models.Log;
import cn.mt.models.User;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class JdbcTest {
    private static final HashMap<String,String> jp = new HashMap<>();

    static {
        jp.put("driverClassName","com.mysql.jdbc.Driver");
        jp.put("url","jdbc:mysql://127.0.0.1:3306/my2ssm?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        jp.put("username","root");
        jp.put("password","123456");
    }


    public static void main(String[] args) throws Exception {
        DataSource dataSource = DruidDataSourceFactory.createDataSource(jp);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Integer count = jdbcTemplate.queryForObject("select count(*) from log", Integer.class);
        System.out.println("count : " + count);

        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select * from log");
        System.out.println(sqlRowSet);
        List<Log> logs = jdbcTemplate.queryForList("select * from log", Log.class);
        System.out.println(logs);
    }
}
