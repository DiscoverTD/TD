package com.yeelee.TD.mapper;

import com.yeelee.TD.entity.TReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 回复表 Mapper 接口
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Repository
public interface TReplyMapper extends BaseMapper<TReply> {

    /**
     * 查询回复次数
     * @param replyId
     * @param type
     * @return
     */
    @Select("select count(pkid) from t_reply where reply_id=#{replyId} and reply_type=#{type}")
    long getReplyNum(@Param("replyId") String replyId, @Param("type") String type);
}
