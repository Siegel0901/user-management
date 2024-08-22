package top.siegel.usermanagement.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.siegel.usermanagement.entity.User;

/**
 * @projectName: user-management
 * @package: top.siegel.usermanagement.dto
 * @className: UserSelfDTO
 * @author: Siegel
 * @createDate: 2024/8/22
 * @createTime: 19:02
 * @description: UserSelfDTO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserSelfDTO", description = "用户自身信息DTO")
@AllArgsConstructor
@NoArgsConstructor
public class UserSelfDTO extends BaseDTO<User>{
    // 性别, 0: 男, 1: 女
    private Integer gender;
    // 地址
    private String address;
    // 个人简介
    private String introduction;
    // 电话
    private String phone;
    // 邮箱
    private String email;

}
