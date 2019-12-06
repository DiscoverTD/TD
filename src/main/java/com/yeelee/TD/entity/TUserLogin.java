package com.yeelee.TD.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户登录表
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TUserLogin对象", description="用户登录表")
public class TUserLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "pkid", type = IdType.UUID)
    private String pkid;

    @ApiModelProperty(value = "用户账号")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码(MD5加密)")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "手机号")
    @TableField("phone_num")
    private String phoneNum;

    @ApiModelProperty(value = "加密盐值")
    @TableField("salt")
    private String salt;

    @ApiModelProperty(value = "微信openId")
    @TableField("wechat_open_id")
    private String wechatOpenId;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "状态 0:锁定;1:未锁定")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "头像地址")
    @TableField("head_img")
    private String headImg;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
