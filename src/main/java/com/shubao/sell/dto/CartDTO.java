package com.shubao.sell.dto;

import lombok.Data;

/**
 * @author Mr.Chris
 * @title: CartDTO
 * @projectName sell
 * @description: 购物车
 * @date 2019/07/11 0011 17:04
 */
@Data
public class CartDTO {
    /** 商品id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
