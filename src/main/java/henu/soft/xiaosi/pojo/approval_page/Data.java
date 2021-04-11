package henu.soft.xiaosi.pojo.approval_page;

/**
 * Copyright 2021 json.cn
 */

import henu.soft.xiaosi.pojo.declarationform.FormInfoFaceSchoolMajor;
import henu.soft.xiaosi.pojo.declarationform.FormInfoTeacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 总申报表信息展示-申报表审核情况 数据
 * Auto-generated: 2021-02-07 12:22:54
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {

    // 1. 申报表ID

    private String formID;

    // 基层教学组织管理员的userNumber

    private String userNumber;

    // 2. 组织名称
    private String organization;

    // 3. 所属学院
    private String college;

    // 4. 负责人
    private String principal;

    // 5. 职称
    private String professionalTitle;

    // 6. 审核状态
    private String status;

    // 7. 审核人
    private String reviewer;

    // 8. 审核人工号
    private String userNumberOfReviewer;


    // 9. 评测人工号
    private String userNumberOfMarker;

    // 10. 总分数

    private String totalScore;

    // 类型
    private String type;
    // 级别
    private String level;
    // 设立时间
    private String createYear;
    // 负责人工号
    private String principalNumber;
    // 面向多个专业个数
    private String faceMultiple;

    // 面向多个专业及其代码
    private List<FormInfoFaceSchoolMajor> faceSchoolMajors;

    //获奖等级
    private String awardLevel;
    //教师姓名,工号，是否团对负责人
    private List<FormInfoTeacher> teacher;

    //团队名称
    private String teamName;
    //类型
    private String baseEducationType;
    //类别
    private String teamType;
    //获得时间
    private String getTime;
    //等级
    private String teamLevel;
    //授予部门
    private String awardDepartment;


}
