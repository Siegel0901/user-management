package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.siegel.usermanagement.entity.Permission;
import top.siegel.usermanagement.service.PermissionService;
import top.siegel.usermanagement.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author Siegel
* @description 针对表【permission(权限表)】的数据库操作Service实现
* @createDate 2024-08-20 19:59:49
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




