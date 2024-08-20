package top.siegel.usermanagement.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色权限关联表
 * @TableName role_permission
 */
@TableName(value ="role_permission")
@Data
public class RolePermission implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer permission;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除 0-否 1-是
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}