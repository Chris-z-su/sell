package com.shubao.sell.dataobject;

import com.shubao.sell.enums.OrderStatusEnum;
import com.shubao.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *  订单表实体类
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /** 支付状态，默认为0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /** 创建时间. */
    private Date createTime;
    /** 更新时间. */
    private Date updateTime;

    //避免查询数据库时   字段 与 实体类属性   不对应问题，
//    @Transient
//    private List<OrderDetail> orderDetailList;
}
