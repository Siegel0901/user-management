package top.siegel.usermanagement.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.siegel.usermanagement.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author Siegel
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-08-20 19:59:49
* @Entity top.siegel.usermanagement.entity.User
*/
public interface UserMapper extends BaseMapper<User> {
    @Select("<script>" +
            "SELECT " +
            "    u.`id` AS userId, " +
            "    GROUP_CONCAT(DISTINCT r.id) AS roleIdList, " +
            "    GROUP_CONCAT(DISTINCT r.name) AS roleNameList, " +
            "    GROUP_CONCAT(DISTINCT p.id) AS permissionIdList, " +
            "    GROUP_CONCAT(DISTINCT p.name) AS permissionNameList, " +
            "    GROUP_CONCAT(DISTINCT p.code) AS permissionCodeList," +
            "    GROUP_CONCAT(DISTINCT p.platform) AS platformList " +
            "FROM `user` u " +
            "LEFT JOIN `user_role` ur ON u.id = ur.user_id " +
            "LEFT JOIN `role` r ON ur.role_id = r.id " +
            "LEFT JOIN `role_permission` rp ON r.id = rp.role_id " +
            "LEFT JOIN `permission` p ON rp.permission_id = p.id " +
            "WHERE u.id IN " +
            "<foreach collection='userIds' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach> " +
            "GROUP BY u.id" +
            "</script>")
    List<Map<String, Object>> getUserRoleAndPermissionsByUserId(@Param("userIds") List<Long> userIds);

    String userSearchWhereSql = "u.`status` != " + User.Status.DELETED_STR +
            "<if test='userName != null'> AND u.`user_name` LIKE CONCAT('%', #{userName}, '%') </if>" +
            "<if test='minCreateTime != null'>AND u.`create_time` &gt;= #{minCreateTime} </if>" +
            "<if test='maxCreateTime != null'>AND u.`create_time` &lt;= #{maxCreateTime} </if>";

    @Select("<script>" +
            "SELECT u.* FROM `user` u " +
            "<where>" + userSearchWhereSql + "</where>" +
            "ORDER BY #{orderBy} #{orderMethod} " +
            "LIMIT #{start}, #{length}" +
            "</script>")
    List<User> getUserList(@Param("userName") String userName,
                           @Param("minCreateTime") String minCreateTime,
                           @Param("maxCreateTime") String maxCreateTime,
                           @Param("orderBy") String orderBy,
                           @Param("orderMethod") String orderMethod,
                           @Param("start") Integer start,
                           @Param("length") Integer length);

    @Select("<script>" +
            "SELECT COUNT(*) FROM `user` u " +
            "<where>" + userSearchWhereSql + "</where>" +
            "</script>")
    int countUserList(@Param("userName") String userName,
                      @Param("minCreateTime") String minCreateTime,
                      @Param("maxCreateTime") String maxCreateTime);

}




