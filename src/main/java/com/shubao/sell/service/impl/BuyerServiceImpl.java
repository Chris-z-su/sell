package com.shubao.sell.service.impl;

import com.shubao.sell.dto.OrderDTO;
import com.shubao.sell.enums.ResultEnum;
import com.shubao.sell.exception.SellException;
import com.shubao.sell.service.BuyerService;
import com.shubao.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】订单不存在，orderId={}",orderDTO);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }

        //判断是否是当前用户的订单
//        equalsIgnoreCase()会忽略大小写，
//        equals()不会忽略大小写
//        https://beginnersbook.com/2013/12/java-string-equals-and-equalsignorecase-methods-example/
//        The only difference between them is that the equals() methods considers the case
//        while equalsIgnoreCase() methods ignores the case during comparison.
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致.openid={},orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }

}
