package com.yeelee.TD.mapper;

import com.yeelee.TD.entity.TPraise;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 点赞表 Mapper 接口
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
public interface TPraiseMapper extends BaseMapper<TPraise> {

    @Select("select count(pkid) from t_praise where type_id=#{typeId} and type=#{type} and status=1")
    long getPraiseNum(@Param("typeId") String typeId,@Param("type") String type);
}
