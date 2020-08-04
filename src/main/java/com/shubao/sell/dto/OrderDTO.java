package com.shubao.sell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shubao.sell.dataobject.OrderDetail;
import com.shubao.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.Chris
 * @title: OrderDTO
 * @projectName sell
 * @description: TODO
 * @date 2019/07/11 0011 15:42
 */
@Data
// 已过时
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
// 如果不需要返回值为空的字段，则添加以下注解，
// 也可以添加全局配置，参见application.yml
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单id. */
    private String orderId;

    /** 买家姓名. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态，默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态，默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
//  设置初始值，返回结果如果为空 则为[]  而不是 null
//    如果是String类型，则设置为 String name = "";  返回值为 "" ,方便前台处理
//    List<OrderDetail> orderDetailList = new ArrayList<>();
//关于返回值的处理，还包括application.yml中的配置，根据项目具体情况做选择
    //jackson:
    //    default-property-inclusion: non_null
}
