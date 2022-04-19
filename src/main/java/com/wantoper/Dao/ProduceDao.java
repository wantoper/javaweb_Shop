package com.wantoper.Dao;

import com.wantoper.Util.MybatisUtil;
import com.wantoper.pojo.Product;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ProduceDao {

    public static List<Product> getproduct(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        ProduceMapper mapper = getsqlseesion.getMapper(ProduceMapper.class);
        List<Product> getproduces = mapper.getproduces();
        getsqlseesion.close();

        return getproduces;
    }

    @Test
    public static Product gerproduct(int id){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        ProduceMapper mapper = getsqlseesion.getMapper(ProduceMapper.class);
        Product gerproduce = mapper.gerproduce(id);
        getsqlseesion.close();
        return gerproduce;
    }
}
