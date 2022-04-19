import com.wantoper.Dao.OrderItemMapper;
import com.wantoper.Dao.OrderMapper;
import com.wantoper.Dao.ProduceMapper;
import com.wantoper.Dao.UserMapper;
import com.wantoper.Util.MybatisUtil;
import com.wantoper.Util.UidUtil;
import com.wantoper.pojo.Order;
import com.wantoper.pojo.OrderItem;
import com.wantoper.pojo.Product;
import com.wantoper.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    public void getorderoid(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        OrderMapper mapper1 = getsqlseesion.getMapper(OrderMapper.class);
        List<Map<String, Object>> str = mapper1.getorderbyoid("d98a9b6e2e404d4699a456ae597e802b");
        for (Map<String, Object> stringStringMap : str) {
            System.out.print(stringStringMap.get("pname")+"\t");
            System.out.print(stringStringMap.get("price")+"\t");
            System.out.print(stringStringMap.get("num")+"\t");
            System.out.print(stringStringMap.get("OrderMoney")+"\t");
            System.out.print(stringStringMap.get("id")+"\t");
            System.out.println();
        }

        getsqlseesion.close();
    }


    @Test
    public void getorder(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        OrderMapper mapper1 = getsqlseesion.getMapper(OrderMapper.class);
        List<Order> orders = mapper1.getorderbyid("b0b31f5d300f4ecba54546f172496b2c");
        for (Order order : orders) {
            System.out.println(order);
        }
        getsqlseesion.close();
    }

    @Test
    public void addorderitem(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        OrderItemMapper mapper = getsqlseesion.getMapper(OrderItemMapper.class);
        mapper.addOrderItem(new OrderItem(UidUtil.getid(),3,"a9b6f3a42ec343e5bd59bc02dd4233bd",3,null));
        getsqlseesion.commit();
        getsqlseesion.close();
    }

    @Test
    public void addorder(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        OrderMapper mapper1 = getsqlseesion.getMapper(OrderMapper.class);
        mapper1.addorder(new Order(UidUtil.getid(),"abc", LocalDateTime.now(),100));
        getsqlseesion.commit();
        getsqlseesion.close();
    }


    @Test
    public void gerproduct(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        ProduceMapper mapper = getsqlseesion.getMapper(ProduceMapper.class);
        Product gerproduce = mapper.gerproduce(1);
        System.out.println(gerproduce);
        getsqlseesion.close();
    }


    @Test
    public void getproduct(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        ProduceMapper mapper = getsqlseesion.getMapper(ProduceMapper.class);
        List<Product> getproduces = mapper.getproduces();
        for (Product getproduce : getproduces) {
            System.out.println(getproduce);
        }
        getsqlseesion.close();
    }


    @Test
    public void teset(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        UserMapper mapper = getsqlseesion.getMapper(UserMapper.class);
        List<User> getusers = mapper.getusers();
        for (User getuser : getusers) {
            System.out.println(getuser);
        }

        getsqlseesion.close();
    }

    @Test
    public void adduser(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        UserMapper mapper = getsqlseesion.getMapper(UserMapper.class);
        mapper.adduser(new User(UidUtil.getid(),"admin","admin"));
        getsqlseesion.commit();
        getsqlseesion.close();
    }

    @Test
    public void login(){
        SqlSession getsqlseesion = MybatisUtil.getsqlseesion();
        UserMapper mapper = getsqlseesion.getMapper(UserMapper.class);
        User login = mapper.login(new User(null,"admin", "admin"));
        System.out.println(login);
        getsqlseesion.close();
    }
}
