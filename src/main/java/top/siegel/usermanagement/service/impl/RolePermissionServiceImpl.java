package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.siegel.usermanagement.entity.RolePermission;
import top.siegel.usermanagement.service.RolePermissionService;
import top.siegel.usermanagement.mapper.RolePermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author Siegel
* @description 针对表【role_permission(角色权限关联表)】的数据库操作Service实现
* @createDate 2024-08-20 19:59:49
*/
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
    implements RolePermissionService{

}




