package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.siegel.usermanagement.entity.UserRole;
import top.siegel.usermanagement.service.UserRoleService;
import top.siegel.usermanagement.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Siegel
* @description 针对表【user_role(用户角色关联表)】的数据库操作Service实现
* @createDate 2024-08-20 19:59:49
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




