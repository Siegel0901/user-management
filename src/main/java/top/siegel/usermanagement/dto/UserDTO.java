package top.siegel.usermanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.siegel.usermanagement.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: user-management
 * @package: top.siegel.usermanagement.dto
 * @className: UserDTO
 * @author: Siegel
 * @createDate: 2024/8/22
 * @createTime: 18:59
 * @description: UserDTO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserDTO", description = "用户DTO")
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends BaseDTO<User> {
    // 用户id
    @ApiModelProperty(value = "用户id", hidden = true, notes = "用户id, 创建时不需要传")
    private Long id;
    // 用户名
    private String userName;
    // 真实姓名
    private String trueName;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 性别, 0: 男, 1: 女
    private Integer gender;
    // 地址
    private String address;
    // 个人简介
    private String introduction;
    // 电话
    private String phone;
    // 角色列表
    private List<Integer> roleIds;

    public UserDTO(String userName, String password, List<Integer> roleIds) {
        this.userName = userName;
        this.password = password;
        this.roleIds = roleIds;
    }

    @Override
    protected List<String> getExcludeFields() {
        return new ArrayList<String>() {{
            add("roleIds");
        }};
    }

}
