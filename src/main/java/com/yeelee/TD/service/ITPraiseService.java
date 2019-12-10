package com.yeelee.TD.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeelee.TD.entity.TPraise;

/**
 * <p>
 * 点赞表 服务类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
public interface ITPraiseService extends IService<TPraise> {

    /**
     * 获取点赞次数
     * @param typeId
     * @param type 类型：0:对作品点赞;1:对评论点赞;2:对回复点赞
     * @return
     */
    long getPraiseNum(String typeId,String type);
}
