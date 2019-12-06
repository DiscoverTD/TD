package com.yeelee.TD.service.impl;

import com.yeelee.TD.entity.TEnshrine;
import com.yeelee.TD.mapper.TEnshrineMapper;
import com.yeelee.TD.service.ITEnshrineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  收藏 服务实现类
 * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 */
@Service
public class TEnshrineServiceImpl extends ServiceImpl<TEnshrineMapper, TEnshrine> implements ITEnshrineService {

    @Autowired
    TEnshrineMapper enshrineMapper;

    @Override
    public long getEnshrineNum(String composeId) {
        return enshrineMapper.getEnshrineNum(composeId);
    }
}
