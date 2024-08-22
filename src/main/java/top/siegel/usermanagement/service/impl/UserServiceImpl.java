package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.siegel.usermanagement.entity.User;
import top.siegel.usermanagement.mapper.UserMapper;
import top.siegel.usermanagement.service.UserRoleService;
import top.siegel.usermanagement.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Siegel
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-08-20 19:59:49
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRoleService userRoleService) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean existsByUserName(String userName, Boolean throwExceptionWhenExists) throws RuntimeException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", userName.trim()).ne("status", User.Status.DELETED));
        if (throwExceptionWhenExists == null) {
            return user != null;
        } else {
            return false;
        }
    }

    @Override
    public Map<String, Boolean> batchCheckUserName(List<String> userNames) {
        if (userNames == null || userNames.size() == 0) {
            return Collections.emptyMap();
        }
        List<User> existUsers = userMapper.selectList(new QueryWrapper<User>().in("user_name", userNames).ne("status", User.Status.DELETED));
        Set<String> existUserNameSet = existUsers.stream().map(user -> user.getUserName().trim()).collect(Collectors.toSet());
        Map<String, Boolean> result = new HashMap<>();
        for (String name : userNames) {
            result.put(name, existUserNameSet.contains(name));
        }
        return result;
    }

}




