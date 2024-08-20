package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.siegel.usermanagement.entity.Role;
import top.siegel.usermanagement.service.RoleService;
import top.siegel.usermanagement.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Siegel
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2024-08-20 19:59:49
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




