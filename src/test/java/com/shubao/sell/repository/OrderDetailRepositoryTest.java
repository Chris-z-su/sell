package com.shubao.sell.repository;

import com.shubao.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12344446674");
        orderDetail.setOrderId("22222322");
        orderDetail.setProductIcon("http://444.jpg");
        orderDetail.setProductId("123345");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(BigDecimal.valueOf(12.5));
        orderDetail.setProductQuantity(4);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> orderDetailList = repository.findByOrderId("222222");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}