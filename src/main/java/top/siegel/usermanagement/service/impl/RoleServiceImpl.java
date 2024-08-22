package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.siegel.usermanagement.entity.Role;
import top.siegel.usermanagement.enums.StatusEnum;
import top.siegel.usermanagement.exceptions.CustomRuntimeException;
import top.siegel.usermanagement.mapper.RoleMapper;
import top.siegel.usermanagement.service.RoleService;
import top.siegel.usermanagement.utils.DataUtils;

/**
 * @author Siegel
 * @description 针对表【role(角色表)】的数据库操作Service实现
 * @createDate 2024-08-20 19:59:49
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
        implements RoleService {
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public boolean existsByName(String roleName, boolean throwExceptionWhenExists) throws CustomRuntimeException {
        if (DataUtils.checkEmptyString(roleName)) {
            throw new CustomRuntimeException(StatusEnum.ROLE_NAME_NOT_EMPTY);
        }
        Role role = roleMapper.selectOne(new QueryWrapper<Role>().eq("name", roleName.trim()).eq("status", Role.Status.ENABLE));
        if (role != null && throwExceptionWhenExists) {
            throw new CustomRuntimeException(StatusEnum.ROLE_NAME_EXISTS);
        }
        return role != null;
    }

}




