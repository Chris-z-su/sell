package com.shubao.sell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完成"),
    CANCEL(2, "已取消");

    private Integer code;

    private String massage;

    OrderStatusEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }
}
