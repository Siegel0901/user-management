package top.siegel.usermanagement.mapper;

import org.apache.ibatis.annotations.Select;
import top.siegel.usermanagement.entity.Permission;
import top.siegel.usermanagement.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Siegel
* @description 针对表【role_permission(角色权限关联表)】的数据库操作Mapper
* @createDate 2024-08-20 19:59:49
* @Entity top.siegel.usermanagement.entity.RolePermission
*/
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    @Select("SELECT p.* FROM permission p " +
            "LEFT JOIN role_permission rp ON p.id = rp.permission_id " +
            "WHERE rp.role_id = #{roleId}")
    List<Permission> getPermissionsByRoleId(Integer roleId);
}




