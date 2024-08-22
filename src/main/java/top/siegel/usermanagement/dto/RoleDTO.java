package top.siegel.usermanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.siegel.usermanagement.entity.Role;

/**
 * @projectName: user-management
 * @package: top.siegel.usermanagement.dto
 * @className: RoleDTO
 * @author: Siegel
 * @createDate: 2024/8/22
 * @createTime: 19:01
 * @description: RoleDTO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "RoleDTO", description = "角色DTO")
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO extends BaseDTO<Role>{
    // 角色id
    @ApiModelProperty(value = "角色id", hidden = true, notes = "角色id, 创建时不需要传")
    private Integer id;

    // 角色名
    private String name;

    // 角色描述
    private String description;

}
