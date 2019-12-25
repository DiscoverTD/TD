package com.yeelee.TD.mapper.adminMapper;

import com.yeelee.TD.entity.adminEntity.TMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author wzw
 * @since 2019-12-24
 */
@Repository
public interface TMenuMapper extends BaseMapper<TMenu> {

    @Select("select m.*  from t_role r " +
            "  left join t_user_role ur on (r.id = ur.role_id) " +
            "  left join t_user_login u on (u.pkid = ur.user_id) " +
            "  left join t_role_menu rm on (r.id = rm.role_id) " +
            "  left join t_menu m on (m.id = rm.menu_id) " +
            " where u.username = #{username} " +
            "   and m.perms is not null " +
            "   and m.perms != ''")
    List<TMenu> findUserPermissions(String username);
}
