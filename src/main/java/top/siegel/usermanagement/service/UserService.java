package top.siegel.usermanagement.service;

import org.springframework.data.domain.Page;
import top.siegel.usermanagement.dto.UserDTO;
import top.siegel.usermanagement.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import top.siegel.usermanagement.exceptions.CustomRuntimeException;

import java.util.List;
import java.util.Map;

/**
* @author Siegel
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-08-20 19:59:49
*/
public interface UserService extends IService<User> {
    List<Map<String, Object>> getUserRoleAndPermissionsByUserId(List<Long> userIds);

    Page<User> getUserList(String userName, String minCreateTime, String maxCreateTime, String orderBy, String orderMethod, Integer page, Integer pageSize);

    User addOneUser(UserDTO userDTO) throws CustomRuntimeException;

    Map<String, Object> batchCreateUser(List<UserDTO> userDTOS);


    /**
     * 判断用户名是否存在
     * @param userName 用户名
     * @param throwExceptionWhenExists 什么情况下抛出异常
     *                                 null: 不抛出异常, true: 用户名存在时抛出异常, false: 用户名不存在时抛出异常
     */
    boolean existsByUserName(String userName, Boolean throwExceptionWhenExists) throws RuntimeException;

    Map<String, Boolean> batchCheckUserName(List<String> userNames);

}
