package com.yeelee.TD.service.impl;

import com.yeelee.TD.entity.TComment;
import com.yeelee.TD.mapper.TCommentMapper;
import com.yeelee.TD.service.ITCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public long getCommentNum(String composeId) {
        return commentMapper.getCommentNum(composeId);
    }
}
