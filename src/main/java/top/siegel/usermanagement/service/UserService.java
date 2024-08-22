package top.siegel.usermanagement.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.siegel.usermanagement.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author Siegel
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-08-20 19:59:49
*/
public interface UserService extends IService<User> {
    /**
     * 判断用户名是否存在
     * @param userName 用户名
     * @param throwExceptionWhenExists 什么情况下抛出异常
     *                                 null: 不抛出异常, true: 用户名存在时抛出异常, false: 用户名不存在时抛出异常
     */
    boolean existsByUserName(String userName, Boolean throwExceptionWhenExists) throws RuntimeException;

    Map<String, Boolean> batchCheckUserName(List<String> userNames);

}
