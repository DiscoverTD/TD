package com.yeelee.TD.mapper;

import com.yeelee.TD.entity.TEnshrine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  收藏表Mapper 接口
 * </p>
 *
 * @author yeeLee
 * @since 2019-12-01
 */
public interface TEnshrineMapper extends BaseMapper<TEnshrine> {

    /**
     * 获取收藏次数
     * @param composeId
     * @return
     */
    @Select("select count(pkid) from t_enshrine where compose_id = #{composeId}")
    long getEnshrineNum(@Param("composeId") String composeId);
}
