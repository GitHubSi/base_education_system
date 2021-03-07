package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.pojo.role.RoleList;
import henu.soft.xiaosi.service.RoleService;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 1. 查：用户根据自己的角色 获取 分配角色列表
     * @param currentRole
     * @return
     */

    @GetMapping("/list/{currentRole}")
    public ResultResponse findRoleList(@PathVariable String currentRole){


        RoleList roleList = roleService.findRoleListByCurrentRole(currentRole);
        if(roleList == null){
            return ResultResponse.fail(404,"获取角色列表失败！",null);
        }
        return ResultResponse.success(200,"获取角色列表成功！", roleList);

    }
}
