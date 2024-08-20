package top.siegel.usermanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.siegel.usermanagement.entity.LoginLog;
import top.siegel.usermanagement.service.LoginLogService;
import top.siegel.usermanagement.mapper.LoginLogMapper;
import org.springframework.stereotype.Service;

/**
* @author Siegel
* @description 针对表【login_log(登陆日志表)】的数据库操作Service实现
* @createDate 2024-08-20 19:59:49
*/
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog>
    implements LoginLogService{

}




