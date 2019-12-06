package com.yeelee.TD.service;

import com.yeelee.TD.entity.TEnshrine;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  收藏表 服务类
 * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 */
public interface ITEnshrineService extends IService<TEnshrine> {

    /**
     * 获取收藏次数
     * @param composeId
     * @return
     */
    long getEnshrineNum(String composeId);
}
