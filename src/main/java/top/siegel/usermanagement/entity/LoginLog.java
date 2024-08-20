package top.siegel.usermanagement.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 登陆日志表
 * @TableName login_log
 */
@TableName(value ="login_log")
@Data
public class LoginLog implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户ip
     */
    private String ip;

    /**
     * 用户登录时间
     */
    private Date loginTime;

    /**
     * 用户登陆平台
     */
    private Integer platform;

    /**
     * 是否删除 0-否 1-是
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}