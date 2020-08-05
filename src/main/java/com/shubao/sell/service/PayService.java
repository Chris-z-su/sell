package com.shubao.sell.service;

import com.shubao.sell.dto.OrderDTO;

public interface PayService {

    void create(OrderDTO orderDTO);
}
