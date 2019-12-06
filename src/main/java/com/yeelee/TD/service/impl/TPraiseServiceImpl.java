package com.yeelee.TD.service.impl;

import com.yeelee.TD.entity.TPraise;
import com.yeelee.TD.mapper.TPraiseMapper;
import com.yeelee.TD.service.ITPraiseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 点赞表 服务实现类
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Service
public class TPraiseServiceImpl extends ServiceImpl<TPraiseMapper, TPraise> implements ITPraiseService {

    @Autowired
    TPraiseMapper praiseMapper;

    @Override
    public long getPraiseNum(String composeId, String type) {
        return praiseMapper.getPraiseNum(composeId,type);
    }
}
