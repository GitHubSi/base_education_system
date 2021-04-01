package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.pojo.college.CollegeList;
import henu.soft.xiaosi.service.CollegeService;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;


    /**
     * 1. 查：查找学院列表
     * @return
     */
    @GetMapping("/list")
    public ResultResponse findCollegeList(){

        CollegeList collegeList = collegeService.findCollegeList();
        if(collegeList == null){
            return ResultResponse.fail(404,"获取学院列表失败！",null);
        }


        return ResultResponse.success(200,"获取学院列表成功！",collegeList);

    }


}
