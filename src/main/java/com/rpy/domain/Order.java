package com.rpy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_order")
public class Order {
    @TableId(value = "id",type = IdType.INPUT)
    private String id;

    @TableField(value = "userid")
    private Integer userid;

    @TableField(value = "goodsid")
    private Integer goodsid;

    @TableField(value = "createtime")
    private Date createtime;

    /**
     * 状态 0未付款 1已付款  2确认收货
     */
    @TableField(value = "status")
    private Integer status;

    public static final String COL_ID = "id";

    public static final String COL_USERID = "userid";

    public static final String COL_GOODSID = "goodsid";

    public static final String COL_CREATETIME = "createtime";

    public static final String COL_STATUS = "status";
}