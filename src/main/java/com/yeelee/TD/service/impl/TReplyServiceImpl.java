package com.yeelee.TD.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeelee.TD.config.SysConstant;
import com.yeelee.TD.entity.TReply;
import com.yeelee.TD.entity.TUserLogin;
import com.yeelee.TD.mapper.TReplyMapper;
import com.yeelee.TD.service.ITReplyService;
import com.yeelee.TD.service.ITUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 回复表 服务实现类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Service
public class TReplyServiceImpl extends ServiceImpl<TReplyMapper, TReply> implements ITReplyService {

    @Autowired
    private TReplyMapper replyMapper;
    @Autowired
    private ITUserLoginService userLoginService;

    @Override
    public long getReplyNum(String replyId, String type) {
        return replyMapper.getReplyNum(replyId, type);
    }

    @Override
    public List<TReply> getReplyList(String commentId, Long orderNo) {
        QueryWrapper<TReply> queryWrapper = new QueryWrapper<>(new TReply());
        queryWrapper.orderByDesc("order_no");
        queryWrapper.eq("comment_id",commentId);
        if (orderNo != null) {
            // lt 小于 <
            queryWrapper.lt("order_no", orderNo);
        }
        // 最后拼接sql
        queryWrapper.last("limit 0,"+ SysConstant.PAGESIZE+"");
        List<TReply> list = list(queryWrapper);
        for (TReply t : list) {
            // 查询回复人的头像，昵称
            String fromUserid = t.getFromUserid();
            String toUserid = t.getToUserid();
            TUserLogin fromUser = userLoginService.getById(fromUserid);
            t.setFromUserImage(fromUser.getHeadImg());
            t.setFromUserNickname(fromUser.getNickname());
            if (toUserid != null) {
                // 查询目标对象的头像，昵称
                TUserLogin toUser = userLoginService.getById(toUserid);
                t.setToUserImage(toUser.getHeadImg());
                t.setToUserNickname(toUser.getNickname());
            }
        }
        return list;
    }
}
