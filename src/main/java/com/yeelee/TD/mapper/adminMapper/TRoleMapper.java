package com.yeelee.TD.mapper.adminMapper;

import com.yeelee.TD.entity.adminEntity.TRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author wzw
 * @since 2019-12-24
 */
@Repository
public interface TRoleMapper extends BaseMapper<TRole> {

    @Select(" select r.* from t_user_login u " +
            "  left join t_user_role ur on (u.id = ur.user_id) " +
            "  left join t_role r on (r.id = ur.role_id) " +
            "  where u.username = #{username} ")
    List<TRole> findUserRole(String username);
}
