package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.service.DataMaintenanceService;
import henu.soft.xiaosi.vo.ResultResponse;
import henu.soft.xiaosi.vo.VoDataMaintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/data-maintenance")
public class DataMaintenanceController {



    @Autowired
    DataMaintenanceService dataMaintenanceService;
    /**
     * 1. 增：增加学院
     * @return
     */

    @PostMapping("/add-college")
    public ResultResponse saveCollege(@RequestBody VoDataMaintenance dataMaintenance)  {
        Boolean result = dataMaintenanceService.saveCollege(dataMaintenance.getCollegeName());
        if(result){
            return ResultResponse.success(200,"学院添加成功！",null);
        }
        return ResultResponse.fail(404,"学院添加失败！",null);

    }

    /**
     * 2. 增：增加基层教学组织名称
     * @return
     */

    @PostMapping("/add-organization")
    public ResultResponse saveOrganization(@RequestBody VoDataMaintenance dataMaintenance){

        Boolean result = dataMaintenanceService.saveOrganization(dataMaintenance.getGrassRootsTeachingSystemName());
        if(result){
            return ResultResponse.success(200,"教学组织名称添加成功！",null);
        }
        return ResultResponse.fail(404,"教学组织名称添加失败！",null);

    }

    @PostMapping("/add-import-organization")
    public ResultResponse saveImportOrganizations(@RequestBody VoDataMaintenance dataMaintenance){

        Boolean result = dataMaintenanceService.saveImportOrganizations(dataMaintenance.getArrayOfGrassRootsTeachingSystemName());
        if(result){
            return ResultResponse.success(200,"教学组织名称添加成功！",null);
        }
        return ResultResponse.fail(404,"教学组织名称添加失败！",null);

    }


    /**
     * 3. 查
     * 获取所有基层教学组织名称
     */
    @GetMapping("/get-organizations")
    public ResultResponse getOrganizations(){
        List<String> organizations = dataMaintenanceService.getOrganizations();
        return ResultResponse.success(200,"教学组织名称获取！",organizations);

    }




}
