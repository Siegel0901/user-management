package top.siegel.usermanagement.service;

import top.siegel.usermanagement.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author Siegel
* @description 针对表【user_role(用户角色关联表)】的数据库操作Service
* @createDate 2024-08-20 19:59:49
*/
public interface UserRoleService extends IService<UserRole> {
    void addUserRole(Long userId, List<Integer> roleIdList, boolean deleteOldRole);

    void batchAddUserRole(List<Map<String, Object>> userRoleList);

    List<Map<String, Object>> getUserIdsByRoleIds(List<Integer> roleIds);

}
