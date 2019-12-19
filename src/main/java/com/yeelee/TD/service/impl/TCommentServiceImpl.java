package com.yeelee.TD.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeelee.TD.config.SysConstant;
import com.yeelee.TD.entity.TComment;
import com.yeelee.TD.entity.TUserLogin;
import com.yeelee.TD.mapper.TCommentMapper;
import com.yeelee.TD.service.ITCommentService;
import com.yeelee.TD.service.ITPraiseService;
import com.yeelee.TD.service.ITReplyService;
import com.yeelee.TD.service.ITUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements ITCommentService {

    @Autowired
    TCommentMapper commentMapper;
    @Autowired
    ITUserLoginService userLoginService;
    @Autowired
    ITPraiseService praiseService;
    @Autowired
    ITReplyService replyService;

    @Override
    public long getCommentNum(String composeId) {
        return commentMapper.getCommentNum(composeId);
    }

    @Override
    public List<TComment> getCommentList(String composeId,Long orderNo) {
        // 分页查询
        long starTime = System.currentTimeMillis();
        QueryWrapper<TComment> queryWrapper = new QueryWrapper<>(new TComment());
        queryWrapper.eq("compose_id",composeId);
        queryWrapper.orderByDesc("order_no");
        if (orderNo!=null){
            // lt 小于 <
            queryWrapper.lt("order_no",orderNo);
        }
        queryWrapper.last("limit 0,"+ SysConstant.PAGESIZE+"");
        List<TComment> list = list(queryWrapper);
        for (TComment t : list) {
            String commentId = t.getPkid();
            // 查询此评论的点赞次数
            long praiseNum = praiseService.getPraiseNum(commentId, "1");
            t.setPraiseNum(praiseNum);
            // 查询此评论的回复次数
            long replyNum = replyService.getReplyNum(commentId, "com");
            t.setReplyNum(replyNum);
            // 查询此评论的评论人头像，昵称
            TUserLogin user = userLoginService.getById(t.getFromUserid());
            t.setUserImage(user.getHeadImg());
            t.setUserNickname(user.getNickname());
        }
        return list;
    }
}
