package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.pojo.declarationform.DeclarationForm;
import henu.soft.xiaosi.pojo.user.User;
import henu.soft.xiaosi.service.DispatchFormService;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispatch-form")
public class DispatchFormController {

    @Autowired
    DispatchFormService dispatchFormService;


    /**
     * 1. 查：查询已经审核成功的审核表
     * @return
     */

    @GetMapping("/all")
    public ResultResponse findDeclarationForms(){

        List<DeclarationForm> declarationForms = dispatchFormService.findDeclarationForms();
        return ResultResponse.success(200,"获取通过审核的申报表成功！",declarationForms);

    }
    /**
     * 1.1 查：查询未分配评分专家的账号
     */

    @GetMapping("/undispatch")
    public ResultResponse findDeclarationFormsOfUndispatch(){

        List<DeclarationForm> declarationForms = dispatchFormService.findDeclarationFormsOfUndispatch();
        return ResultResponse.success(200,"获取通过审核未分配的申报表成功！",declarationForms);

    }

    /**
     * 2. 查：查评审专家列表
     */

    @GetMapping("/users")
    public ResultResponse findUsers(){

        List<User> userList = dispatchFormService.findUsers();

        return ResultResponse.success(200,"获取评审专家成功！",userList);

    }

    /**
     * 3. 更新：将选中的申报表分配给选中的评审专家
     */
    @PostMapping("/{userNumber}")
    public ResultResponse updateDispatchInfo(@PathVariable String userNumber,@RequestBody List<DeclarationForm> declarationFormList){
        if(declarationFormList.isEmpty()){
            return ResultResponse.success(200,"请选择要分配的申报表！",null);
        }

        Boolean result = dispatchFormService.updateDispatchInfo(userNumber, declarationFormList);
        if(result){
            return ResultResponse.success(200,"分配成功！",null);

        }
        System.out.println("分配失败！");
        return ResultResponse.success(404,"分配失败！",null);



    }



}
