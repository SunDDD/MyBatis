import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import com.mybatis.mybatis.io.Resources;
import com.mybatis.mybatis.sqlsession.SqlSession;
import com.mybatis.mybatis.sqlsession.SqlSessionFactory;
import com.mybatis.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author Carlos
 * @description MyBatis测试
 * @Date 2019/9/26
 */

public class MyBatisTest {
    public static void main(String[] args) throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
