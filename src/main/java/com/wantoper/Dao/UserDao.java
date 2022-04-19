package com.wantoper.Dao;

import com.wantoper.Util.MybatisUtil;
import com.wantoper.pojo.User;
import org.apache.ibatis.session.SqlSession;

public class UserDao {
    public static User userlogin(String name,String password){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        UserMapper mapper = getsqlseesion.getMapper(UserMapper.class);
        User aNull = mapper.login(new User("null", name, password));
        return aNull;
    }

    public static User getuserbyname(String name){
        if (name == null || name.trim().equals("")){
            return null;
        }
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        UserMapper mapper = getsqlseesion.getMapper(UserMapper.class);
        User aNull = mapper.getuserbyname(name);
        return aNull;
    }

    public static void adduser(User user){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        UserMapper mapper = getsqlseesion.getMapper(UserMapper.class);
        mapper.adduser(user);
        getsqlseesion.commit();
    }
}
