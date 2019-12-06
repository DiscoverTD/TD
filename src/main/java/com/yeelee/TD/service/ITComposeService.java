package com.yeelee.TD.service;

import com.yeelee.TD.entity.TCompose;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 日记表(作品) 服务类
 * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 */
public interface ITComposeService extends IService<TCompose> {

    /**
     * 获取评论
     * @return
     */
    List<TCompose> getComposeList(Long pageNum, Long pageSize,TCompose tCompose);
}
