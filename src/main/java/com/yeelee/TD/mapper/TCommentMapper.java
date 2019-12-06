package com.yeelee.TD.mapper;

import com.yeelee.TD.entity.TComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
public interface TCommentMapper extends BaseMapper<TComment> {
    /**
     * 获取评论次数
     * @param composeId
     * @return
     */
    @Select("select count(pkid) from t_comment where compose_id = #{composeId}")
    long getCommentNum(@Param("composeId") String composeId);
}
