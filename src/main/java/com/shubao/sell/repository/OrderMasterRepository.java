package com.shubao.sell.repository;

import com.shubao.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    /**
     * 根据买家openid分页查询
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
