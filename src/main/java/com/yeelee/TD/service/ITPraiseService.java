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
     * @param composeId
     * @param type
     * @return
     */
    long getPraiseNum(String composeId,String type);
}
