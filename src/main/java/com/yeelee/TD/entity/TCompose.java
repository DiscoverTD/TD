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
 * 日记表(作品)
 * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TCompose对象", description="日记表(作品)")
public class TCompose implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "pkid", type = IdType.UUID)
    private String pkid;

    @ApiModelProperty(value = "文字内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "发表人的id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "视频路径(只能上传一个视频)")
    @TableField("video_path")
    private String videoPath;

    @ApiModelProperty(value = "0-禁用 1-可用")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "日记类型,0-日记;其他待定")
    @TableField("record_type")
    private String recordType;

    @ApiModelProperty(value = "经纬度值(通过高德获取)发送的地理位置")
    @TableField("location")
    private String location;

    @ApiModelProperty(value = "是否公开;1-公开，0-私有")
    @TableField("is_open")
    private String isOpen;

    @ApiModelProperty(value = "保存的图片名称，地址需要拼接，名称用uuid生成，多个文件用,隔开")
    @TableField("img_path")
    private String imgPath;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Date createdTime;

    //点赞次数
    @TableField(exist=false) // 非表字段
    private long praiseNum;

    //评论次数
    @TableField(exist=false)
    private long commentNum;

    //收藏次数
    @TableField(exist=false)
    private long enshrineNum;
}
