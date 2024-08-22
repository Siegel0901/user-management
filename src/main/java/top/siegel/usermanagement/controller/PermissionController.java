package top.siegel.usermanagement.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.siegel.usermanagement.entity.Permission;
import top.siegel.usermanagement.service.PermissionService;
import top.siegel.usermanagement.vo.ResponseVO;

import java.util.List;

/**
 * @projectName: user-management
 * @package: top.siegel.usermanagement.controller
 * @className: PermissionController
 * @author: Siegel
 * @createDate: 2024/8/22
 * @createTime: 16:21
 * @description: PermissionController
 */
@RestController
@Api(tags = "permission-api")
@RequestMapping("/permissions")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    @ApiOperation(value = "获取权限列表")
    public ResponseVO<List<Permission>> getPermissionList() {
        List<Permission> permissionList = permissionService.list(new QueryWrapper<>());
        return ResponseVO.success(permissionList);
    }

}
