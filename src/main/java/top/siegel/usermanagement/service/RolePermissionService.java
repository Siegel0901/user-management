package top.siegel.usermanagement.service;

import top.siegel.usermanagement.entity.Permission;
import top.siegel.usermanagement.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Siegel
* @description 针对表【role_permission(角色权限关联表)】的数据库操作Service
* @createDate 2024-08-20 19:59:49
*/
public interface RolePermissionService extends IService<RolePermission> {
    List<Permission> getPermissionsByRoleId(Integer roleId);

}
