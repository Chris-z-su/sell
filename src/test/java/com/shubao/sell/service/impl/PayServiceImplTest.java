package com.shubao.sell.service.impl;

import com.shubao.sell.dto.OrderDTO;
import com.shubao.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        payService.create(orderDTO);
    }
}