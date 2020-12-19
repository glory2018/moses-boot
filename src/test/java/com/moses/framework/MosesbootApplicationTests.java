package com.moses.framework;

import com.moses.framework.samples.strategy.entity.Order;
import com.moses.framework.samples.strategy.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MosesbootApplicationTests {
    @Autowired
    OrderService orderService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void strategy() {
        Order order = new Order();
        order.setSource("pc");
        order.setPayMethod("weChat");
        orderService.orderService(order);
    }
}

