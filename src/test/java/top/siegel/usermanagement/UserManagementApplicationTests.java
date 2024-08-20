package top.siegel.usermanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.siegel.usermanagement.entity.User;
import top.siegel.usermanagement.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class UserManagementApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void testInsert() {
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setUserName("Siegel");
        user.setPassword("root");
        user.setAvatarPath("https://himg.bdimg.com/sys/portraitn/item/public.1.2cdde944.OnKUOGcBXxAfavYSqF529w");
        user.setPhone("15557309927");
        user.setEmail("xuguiqian0901@163.com");
        user.setGender(1);
        user.setAddress("南开大学软件学院");
        user.setIntroduction("无");
        user.setTrueName("徐贵黔");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus(0);
        user.setIsDeleted(0);
        int result = userMapper.insert(user);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testSelection() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assertions.assertEquals(2, userList.size());
        userList.forEach(System.out::println);
    }

}
