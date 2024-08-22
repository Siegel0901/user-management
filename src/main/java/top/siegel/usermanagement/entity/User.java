package top.siegel.usermanagement.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 *
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名称
     */
    @OrderBy(sort = 2)
    private String userName;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 头像url
     */
    private String avatarPath;

    /**
     * 电话号码
     */
    @OrderBy(sort = 8)
    private String phone;

    /**
     * 电子邮箱
     */
    @OrderBy(sort = 4)
    private String email;

    /**
     * 性别 0-女 1-男
     */
    @OrderBy(sort = 5)
    private Integer gender;

    /**
     * 地址
     */
    @OrderBy(sort = 6)
    private String address;

    /**
     * 自我介绍
     */
    @OrderBy(sort = 7)
    private String introduction;

    /**
     * 真实姓名
     */
    @OrderBy(sort = 3)
    private String trueName;

    /**
     * 创建时间
     */
    @OrderBy(sort = 1)
    private Date createTime;

    /**
     * 更新时间
     */
    @OrderBy(sort = 10)
    private Date updateTime;

    /**
     * 用户状态
     */
    @OrderBy(sort = 9)
    private Integer status;

    /**
     * 是否删除 0-否 1-是
     */
    @OrderBy(asc = true, sort = 11)
    @TableLogic
    private Integer isDeleted;

    // 非数据库字段
    @TableField(exist = false)
    private List<String> roleList;

    @TableField(exist = false)
    private List<String> permissionList;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public String generateAvatarName(String suffix) {
        if (!Arrays.asList(".jpg", ".jpeg", ".png", ".gif").contains(suffix)) {
            suffix = ".jpg";
        }
        return id + "_" + userName + suffix;
    }

    public static class Status {
        // 字符串常量用于放在注解中
        public static final String DISABLED_STR = "0";
        public static final String ENABLED_STR = "1";
        public static final String DELETED_STR = "2";

        public static final Integer DISABLE = Integer.parseInt(DISABLED_STR);
        public static final Integer ENABLE = Integer.parseInt(ENABLED_STR);
        public static final Integer DELETED = Integer.parseInt(DELETED_STR);

        public static final String DESC = DISABLED_STR + ": 禁用, " + ENABLED_STR + ": 启用, " + DELETED_STR + ": 删除";
    }

    public static class Gender {
        public static final Integer MALE = 0;
        public static final Integer FEMALE = 1;
    }

    // 排序字段
    public static final String ORDER_FIELDS = "create_time,user_name,true_name,email,gender,address,introduction,phone,status,update_time";
    public static final List<String> ORDER_FIELD_LIST = Arrays.asList(ORDER_FIELDS.split(","));


}