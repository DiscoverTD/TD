package com.yeelee.TD.service;

import com.yeelee.TD.entity.TComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
public interface ITCommentService extends IService<TComment> {

    /**
     * 获取评论次数
     * @param composeId
     * @return
     */
    long getCommentNum(String composeId);

    /**
     *根据日记id获取评论
     * @param composeId
     * @return
     */
    List<TComment> getCommentList(String composeId,Long orderNo);
}
