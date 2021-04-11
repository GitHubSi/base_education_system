package henu.soft.xiaosi.controller;



import henu.soft.xiaosi.pojo.approval_page.Data;
import henu.soft.xiaosi.service.ExportPageService;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 导出功能模块
 */
@RestController
@RequestMapping("/export")
public class ExportPageController {

    @Autowired
    ExportPageService exportPageService;

    @GetMapping("/all")
    public ResultResponse findBySchool(){
        List<Data> dataList = exportPageService.exportSchool();
        return ResultResponse.success(200,"备案表基本信息获取成功!",dataList);
    }



}
