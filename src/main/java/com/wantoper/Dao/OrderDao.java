package com.wantoper.Dao;

import com.wantoper.Util.MybatisUtil;
import com.wantoper.Util.UidUtil;
import com.wantoper.pojo.Order;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class OrderDao {
    public static void addorder(Order order){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        OrderMapper mapper1 = getsqlseesion.getMapper(OrderMapper.class);
        mapper1.addorder(order);
        order.getId();
        order.getCreatedate();
        order.getUid();
        getsqlseesion.commit();
        getsqlseesion.close();
    }

    public static List<Order> getorderbyid(String uid){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        OrderMapper mapper1 = getsqlseesion.getMapper(OrderMapper.class);
        List<Order> orders = mapper1.getorderbyid(uid);
        getsqlseesion.close();

        return orders;
    }


}
