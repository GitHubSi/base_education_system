package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.pojo.approval_page.ApprovalPage;
import henu.soft.xiaosi.pojo.approval_page.Data;
import henu.soft.xiaosi.service.ApprovalPageService;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApprovalPageController {

    @Autowired
    ApprovalPageService approvalPageService;

    /**
     * 1. 查：获取全部申报表列表
     */

    @GetMapping("/approval-page")
    public ResultResponse getDeclarationFormsList(){
        ApprovalPage approvalPageList = approvalPageService.findFormList();
        System.out.println("debug=>"+ approvalPageList);
        if(approvalPageList != null){
            return ResultResponse.success(200,"获取审核表列表成功！",approvalPageList);
        }
        return ResultResponse.fail(404,"获取审核表列表失败！",null);

    }



    /**
     * 2. 增：插入创建的新申报表
     */
    @PostMapping("/approval-page")
    public ResultResponse saveDeclarationFormsList(@RequestBody Data data){
        Boolean insertResult = approvalPageService.updateFormList(data);

        if(insertResult){
            return ResultResponse.success(200,"插入成功！",null);
        }
        return ResultResponse.fail(404,"插入失败！",null);
    }

    /**
     * 3. 删除：删除点击的申报表
     */
    @DeleteMapping("/approval-page")
    public ResultResponse deleteDeclarationFormsByInfo(@RequestBody Data data){
        Boolean insertResult = approvalPageService.deleteDeclarationFormByInfo(data);
        System.out.println("debug==>删除的申报表审核信息：" + data);

        if(insertResult){
            return ResultResponse.success(200,"删除成功！",null);
        }
        return ResultResponse.fail(404,"删除失败！",null);
    }



}
