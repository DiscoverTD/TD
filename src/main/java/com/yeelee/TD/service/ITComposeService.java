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
     *
     * @param tCompose
     * @param orderNo 每次查出来日记表中最小的排序值作为条件查询数据库，如果没有则代表第一次查询，不需要条件了
     * @return
     */
    List<TCompose> getComposeList(TCompose tCompose,Long orderNo);
}
