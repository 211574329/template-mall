package com.echo.mall.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author echo
 * @since 2023-07-26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单编号
     */
    private Long orderNo;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 产品spu-id
     */
    private Long spuId;

    /**
     * 产品sku-id
     */
    private Long skuId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 配送类型：无需快递
     */
    private Integer deliveryType;

    /**
     * 订单商品总数
     */
    private Integer allCount;

    /**
     * 产品价格
     */
    private BigDecimal price;

    /**
     * 总值
     */
    private BigDecimal total;

    /**
     * 订单状态 1:待付款 2:待发货 3:待收货(已发货) 5:成功 6:失败
     */
    private Integer status;

    /**
     * 付款时间
     */
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 完成时间
     */
    private LocalDateTime finallyTime;

    /**
     * 结算时间
     */
    private LocalDateTime settledTime;

    /**
     * 取消时间
     */
    private LocalDateTime cancelTime;

    /**
     * 支付类型  1:支付宝 2:微信 3:网银
     */
    private Integer payType;

    /**
     * 支付流水号
     */
    private Long payNo;

    /**
     * 是否已支付，1.已支付0.未支付
     */
    private Boolean isPayed;

    /**
     * 订单关闭原因 1-超时未支付 4-买家取消 15-已通过货到付款交易
     */
    private Integer closeType;

    /**
     * 用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除
     */
    private Integer deleted;

    /**
     * 订单版本号，每处理一次订单，版本号+1
     */
    private Integer version;

    /**
     * 用户订单地址id
     */
    private Long orderAddrId;


}
