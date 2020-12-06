package com.rpy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 商品
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_goods")
public class Goods {
    /**
     * 商品ID
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Long goodsId;

    /**
     * 商品名称
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 店铺id
     */
    @TableField(value = "shop_id")
    private Long shopId;

    /**
     * 原价
     */
    @TableField(value = "ori_price")
    private BigDecimal oriPrice;

    /**
     * 现价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 简要描述,卖点等
     */
    @TableField(value = "brief")
    private String brief;

    /**
     * 详细描述
     */
    @TableField(value = "content")
    private String content;

    /**
     * 商品主图
     */
    @TableField(value = "picture")
    private String picture;

    /**
     * 商品图片，以,分割
     */
    @TableField(value = "imgs")
    private String imgs;

    /**
     * 默认是1，表示正常状态, -1表示删除, 0下架
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 商品分类
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 销量
     */
    @TableField(value = "sold_num")
    private Integer soldNum;

    /**
     * 总库存
     */
    @TableField(value = "total_stocks")
    private Integer totalStocks;

    /**
     * 配送方式json见TransportModeVO
     */
    @TableField(value = "delivery_mode")
    private String deliveryMode;

    /**
     * 运费模板id
     */
    @TableField(value = "delivery_template_id")
    private Long deliveryTemplateId;

    /**
     * 录入时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 上架时间
     */
    @TableField(value = "putaway_time")
    private Date putawayTime;

    /**
     * 版本 乐观锁
     */
    @TableField(value = "version")
    private Integer version;

    /**
     * 是否参与秒杀1是0否
     */
    @TableField(value = "ismiaosha")
    private Integer ismiaosha;

    public static final String COL_GOODS_ID = "goods_id";

    public static final String COL_GOODS_NAME = "goods_name";

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_ORI_PRICE = "ori_price";

    public static final String COL_PRICE = "price";

    public static final String COL_BRIEF = "brief";

    public static final String COL_CONTENT = "content";

    public static final String COL_PICTURE = "picture";

    public static final String COL_IMGS = "imgs";

    public static final String COL_STATUS = "status";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_SOLD_NUM = "sold_num";

    public static final String COL_TOTAL_STOCKS = "total_stocks";

    public static final String COL_DELIVERY_MODE = "delivery_mode";

    public static final String COL_DELIVERY_TEMPLATE_ID = "delivery_template_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_PUTAWAY_TIME = "putaway_time";

    public static final String COL_VERSION = "version";

    public static final String COL_ISMIAOSHA = "ismiaosha";
}