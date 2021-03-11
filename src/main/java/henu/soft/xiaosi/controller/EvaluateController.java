package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.service.EvaluateService;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {


    @Autowired
    EvaluateService evaluateService;

    /**
     * 1. 评审专家打分
     * @param formID
     * @param totalScore
     * @return
     */

    @PostMapping("/total-score/{formID}/{totalScore}")
    public ResultResponse giveTotalScore(@PathVariable String formID, @PathVariable String totalScore){
        Boolean result = evaluateService.giveTotalScore(formID, totalScore);
        if(result){
            return ResultResponse.success(200,"评分成功！",null);

        }
        return ResultResponse.fail(404,"评分失败！",null);


    }
}
