package com.yeelee.TD.mapper.adminMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeelee.TD.entity.TUserLogin;
import org.apache.ibatis.annotations.Select;
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
public interface AdminUserLoginMapper extends BaseMapper<TUserLogin> {

    TUserLogin selectUserone(String username);

    @Select("select pkid,username, phone_num as phoneNum, `name`, status,head_img as headImg, nickname from t_user_login ")
    List<TUserLogin> selectUserList();
}
