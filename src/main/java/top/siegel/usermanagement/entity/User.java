package top.siegel.usermanagement.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
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
    private Integer id;

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
}