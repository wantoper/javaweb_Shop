package com.wantoper.Dao;

import com.wantoper.Util.MybatisUtil;
import com.wantoper.Util.UidUtil;
import com.wantoper.pojo.OrderItem;
import org.apache.ibatis.session.SqlSession;

public class OrderItemDao {
    public static void addorderitem(OrderItem order){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        OrderItemMapper mapper = getsqlseesion.getMapper(OrderItemMapper.class);
        mapper.addOrderItem(order);
        getsqlseesion.commit();
        getsqlseesion.close();
    }
}
