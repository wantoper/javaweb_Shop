package com.wantoper.Dao;

import com.wantoper.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProduceMapper {
    @Select("select * from Product")
    List<Product> getproduces();

    @Select("select * from Product where id=#{id}")
    Product gerproduce(int id);
}
