package com.yeelee.TD.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeelee.TD.entity.TCompose;
import com.yeelee.TD.mapper.TComposeMapper;
import com.yeelee.TD.service.ITCommentService;
import com.yeelee.TD.service.ITComposeService;
import com.yeelee.TD.service.ITEnshrineService;
import com.yeelee.TD.service.ITPraiseService;
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

    @Override
    public List<TCompose> getComposeList(Long pageNum, Long pageSize, TCompose tCompose) {
        // 分页查询
        IPage<TCompose> page = page(new Page<>(pageNum, pageSize), new QueryWrapper<>(tCompose));
        long starTime = System.currentTimeMillis();

        List<TCompose> records = page.getRecords();
        for (TCompose t : records) {
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
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:"+(endTime-starTime)/1000+"s");
        return records;
    }
}
