package mapper;

import domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface UserMapper {
    @Insert("INSERT INTO USERS (id,name,password) VALUES (#{id},#{name},#{password})")
    int insert(User user);//插入用户
    @Select("SELECT * FROM USERS WHERE id=#{param1} and password=(#{param2})")
    User checkUser(int id,String password);
}
