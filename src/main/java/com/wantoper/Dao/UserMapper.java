package com.wantoper.Dao;

import com.wantoper.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;

import java.util.List;

public interface UserMapper {

    @Select("select * from User")
    List<User> getusers();
    @Insert("insert into User values(#{id},#{name},#{password})")
    int adduser(User user);

    @Select("select * from User where name=#{name} and password=#{password}")
    User login(User s);

    @Select("select * from User where name=#{name}")
    User getuserbyname(String name);
}
