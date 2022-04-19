package com.wantoper.Dao;

import com.wantoper.pojo.OrderItem;
import org.apache.ibatis.annotations.Insert;

public interface OrderItemMapper {

    @Insert("insert into OrderItem values(#{id},#{pid},#{oid},#{num})")
    int addOrderItem(OrderItem orderItem);
}
