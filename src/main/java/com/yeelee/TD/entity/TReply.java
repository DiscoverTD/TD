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
 * 回复表
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TReply对象", description="回复表")
public class TReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "pkid", type = IdType.UUID)
    private String pkid;

    @ApiModelProperty(value = "评论id")
    @TableField("comment_id")
    private String commentId;

    @ApiModelProperty(value = "回复目标id")
    @TableField("reply_id")
    private String replyId;

    @ApiModelProperty(value = "回复类型(com: 表示针对评论进行回复; rep:表示针对回复进行回复)")
    @TableField("reply_type")
    private String replyType;

    @ApiModelProperty(value = "回复内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "回复的用户id")
    @TableField("from_userid")
    private String fromUserid;

    @ApiModelProperty(value = "目标用户id")
    @TableField("to_userid")
    private String toUserid;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "排序编号")
    @TableField("order_no")
    private Long orderNo;

    //回复人的头像
    @TableField(exist=false)
    private String fromUserImage;

    //回复人的昵称
    @TableField(exist=false)
    private String fromUserNickname;

    //目标人的头像
    @TableField(exist=false)
    private String toUserImage;

    //目标人的昵称
    @TableField(exist=false)
    private String toUserNickname;
}
