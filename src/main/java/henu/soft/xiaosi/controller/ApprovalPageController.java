package henu.soft.xiaosi.controller;

import com.mongodb.client.result.UpdateResult;
import henu.soft.xiaosi.pojo.approvalPage.ApprovalPage;
import henu.soft.xiaosi.pojo.approvalPage.Data;
import henu.soft.xiaosi.service.ApprovalPageService;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApprovalPageController {

    @Autowired
    ApprovalPageService approvalPageService;

    /**
     * 1. 获取全部申报表列表
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
     * 2. 更新申报表列表
     */
    @PostMapping("/approval-page")
    public ResultResponse updateDeclarationFormsList(@RequestBody Data data){
        Boolean insertResult = approvalPageService.updateFormList(data);

        if(insertResult){
            return ResultResponse.success(200,"插入成功！",null);
        }
        return ResultResponse.fail(404,"插入失败！",null);
    }
}
