package top.siegel.usermanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.siegel.usermanagement.entity.Role;

/**
* @author Siegel
* @description 针对表【role(角色表)】的数据库操作Service
* @createDate 2024-08-20 19:59:49
*/
public interface RoleService extends IService<Role> {
    boolean existsByName(String roleName, boolean throwExceptionWhenExists) throws RuntimeException;

}
