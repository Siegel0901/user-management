package top.siegel.usermanagement.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.siegel.usermanagement.entity.User;
import top.siegel.usermanagement.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author Siegel
* @description 针对表【user_role(用户角色关联表)】的数据库操作Mapper
* @createDate 2024-08-20 19:59:49
* @Entity top.siegel.usermanagement.entity.UserRole
*/
public interface UserRoleMapper extends BaseMapper<UserRole> {
    @Select("<script>" +
            "SELECT `user`.`id` AS `userId` FROM `user` " +
            "LEFT JOIN `user_role` ON `user`.`id` = `user_role`.`user_id` " +
            "WHERE `user`.`status` != " + User.Status.DELETED_STR +
            " AND `user_role`.`role_id` IN " +
            "<foreach collection='roleIds' item='roleId' open='(' separator=',' close=')'>" +
            "#{roleId}" +
            "</foreach>" +
            "GROUP BY user_id" +
            "</script>")
    List<Map<String, Object>> getUserIdsByRoleIds(@Param("roleIds") List<Integer> roleIds);

}




