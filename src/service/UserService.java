package service;

import domain.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Administrator on 2017/6/22.
 */
public class UserService {
    public User check(int id,String password) throws Exception{
        Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user1=userMapper.checkUser(id,password);
        if(user1!=null){
            System.out.println(user1.getId()+":"+user1.getPassword());
            return user1;
        }
        return null;
    }
}
