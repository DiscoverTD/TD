package com.yeelee.TD.mapper;

import com.yeelee.TD.entity.TUserLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户登录表 Mapper 接口
 * </p>
 *
 * @author yeeLee
 * @since 2019-11-28
 */
@Repository
public interface TUserLoginMapper extends BaseMapper<TUserLogin> {

    TUserLogin selectUserone(String username);

    @Select("select pkid,username, phone_num as phoneNum, `name`, status,head_img as headImg, nickname from t_user_login ")
    List<TUserLogin> selectUserList();
}
