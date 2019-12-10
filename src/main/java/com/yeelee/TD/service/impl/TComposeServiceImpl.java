package com.yeelee.TD.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeelee.TD.entity.TCompose;
import com.yeelee.TD.entity.TUserLogin;
import com.yeelee.TD.mapper.TComposeMapper;
import com.yeelee.TD.service.*;
import com.yeelee.TD.utils.BizProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 日记表(作品) 服务实现类
 * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 */
@Service
public class TComposeServiceImpl extends ServiceImpl<TComposeMapper, TCompose> implements ITComposeService {

    @Autowired
    ITPraiseService praiseService;
    @Autowired
    ITCommentService commentService;
    @Autowired
    ITEnshrineService enshrineService;
    @Autowired
    ITUserLoginService userLoginService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<TCompose> getComposeList(TCompose tCompose,Long orderNo) {
        // 分页查询
        long starTime = System.currentTimeMillis();
        QueryWrapper<TCompose> queryWrapper = new QueryWrapper<>(tCompose);

        queryWrapper.orderByDesc("order_no");
        if (orderNo!=null){
            // lt 小于 <
            queryWrapper.lt("order_no",orderNo);
        }
        // 最后拼接sql
        queryWrapper.last("limit 0,"+BizProperties.PAGESIZE+"");
        List<TCompose> list = list(queryWrapper);
        for (TCompose t : list) {
            String pkid = t.getPkid();
            // 查询点赞次数
            long praiseNum = praiseService.getPraiseNum(pkid, "0");
            t.setPraiseNum(praiseNum);
            // 查询评论次数
            long commentNum = commentService.getCommentNum(pkid);
            t.setCommentNum(commentNum);
            // 查询收藏次数
            long enshrineNum = enshrineService.getEnshrineNum(pkid);
            t.setEnshrineNum(enshrineNum);
            // 查询日记发表人的头像，昵称，和id
            TUserLogin user = userLoginService.getById(t.getUserId());
            t.setUserImage(user.getHeadImg());
            t.setUserNickname(user.getNickname());
        }
        long endTime = System.currentTimeMillis();
        logger.info("查询日记总耗时:"+(endTime-starTime)/1000+"s");
        return list;
    }
}
