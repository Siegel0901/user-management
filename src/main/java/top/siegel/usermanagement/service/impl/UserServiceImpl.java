package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.siegel.usermanagement.entity.User;
import top.siegel.usermanagement.service.UserService;
import top.siegel.usermanagement.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Siegel
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-08-20 19:59:49
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




