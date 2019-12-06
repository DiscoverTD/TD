package com.yeelee.TD.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 点赞表
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TPraise对象", description="点赞表")
public class TPraise implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "pkid", type = IdType.UUID)
    private String pkid;

    @ApiModelProperty(value = "类型：0:对作品点赞;1:对评论点赞;2:对回复点赞")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "对应的作品或评论的id")
    @TableField("type_id")
    private String typeId;

    @ApiModelProperty(value = "点赞的用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "点赞状态；0:取消点赞;1:点赞")
    @TableField("status")
    private String status;


}
