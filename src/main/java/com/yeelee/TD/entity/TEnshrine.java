package com.yeelee.TD.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TEnshrine对象", description="")
public class TEnshrine implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pkid", type = IdType.UUID)
    private String pkid;

    @TableField("compose_id")
    private String composeId;

    @TableField("user_id")
    private String userId;

    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime;


}
