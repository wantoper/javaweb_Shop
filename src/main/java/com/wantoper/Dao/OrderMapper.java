package com.wantoper.Dao;

import com.wantoper.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    @Insert("insert into `Order` values(#{id},#{uid},#{createdate},#{ordermoney})")
    int addorder(Order order);

    @Select("select * from `Order` where uid = #{uuid}")
    List<Order> getorderbyid(String uuid);

    @Select("select *,p.name pname,oi.id oiid from `User` u,OrderItem oi ,`Order` o ,Product p\n" +
            "where o.id = oi.oid and o.uid =u.id and oi.pid  = p.id\n" +
            "and o.id  =#{oid};")
    List<Map<String,Object>> getorderbyoid(String oid);
}
