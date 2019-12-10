package com.yeelee.TD.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * 评论表
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TComment对象", description="评论表")
public class TComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "pkid", type = IdType.UUID)
    private String pkid;

    @ApiModelProperty(value = "作品id")
    @TableField("compose_id")
    private String composeId;

    @ApiModelProperty(value = "评论内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "评论用户id")
    @TableField("from_userid")
    private String fromUserid;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "排序编号")
    @TableField("order_no")
    private Long orderNo;

    //点赞次数
    @TableField(exist=false)
    private long praiseNum;

    //回复次数
    @TableField(exist=false)
    private long replyNum;

    //发表日记人的头像
    @TableField(exist=false)
    private String userImage;

    //发表日记人的昵称
    @TableField(exist=false)
    private String userNickname;
}
