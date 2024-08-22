package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.siegel.usermanagement.entity.Permission;
import top.siegel.usermanagement.entity.RolePermission;
import top.siegel.usermanagement.mapper.RolePermissionMapper;
import top.siegel.usermanagement.service.RolePermissionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Siegel
 * @description 针对表【role_permission(角色权限关联表)】的数据库操作Service实现
 * @createDate 2024-08-20 19:59:49
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
        implements RolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;

    @Autowired
    public RolePermissionServiceImpl(RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public List<Permission> getPermissionsByRoleId(Integer roleId) {
        return rolePermissionMapper.getPermissionsByRoleId(roleId);
    }
}




