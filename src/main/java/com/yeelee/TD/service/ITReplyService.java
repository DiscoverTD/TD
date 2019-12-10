package com.yeelee.TD.service;

import com.yeelee.TD.entity.TReply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 回复表 服务类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
public interface ITReplyService extends IService<TReply> {

    /**
     *
     * @param replyId 回复目标id
     * @param type 回复类型(com: 表示针对评论进行回复;rep:表示针对回复进行回复)
     * @return
     */
    long getReplyNum(String replyId,String type);

    /**
     * 查询此评论下的回复
     * @param commentId
     * @param orderNo
     * @return
     */
    List<TReply> getReplyList(String commentId,Long orderNo);
}
