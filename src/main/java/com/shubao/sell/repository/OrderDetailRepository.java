package com.shubao.sell.repository;

import com.shubao.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Mr.Chris
 * @title: OrderDetailRepository
 * @projectName sell
 * @description: TODO
 * @date 2019/7/10 星期三 17:09
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
