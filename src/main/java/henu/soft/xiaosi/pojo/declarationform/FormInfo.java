package henu.soft.xiaosi.pojo.declarationform;

/**
 * 申报表基本信息
 * Copyright 2021 json.cn
 */

import lombok.*;

import java.util.List;

/**
 * Auto-generated: 2021-02-07 13:41:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormInfo {

    private String formID;

    // 填报人的userNumber
    private String userNumber;

    // 1. 教学组织名称
    private String organization;

    //2. 所属学院
    private String college;

    // 3. 负责人
    private String principal;

    // 4. 职称
    private String professionalTitle;

    // 5. 审核状态
    private String status;

    // 6. 审核人
    private String reviewer;

    private String userNumberOfReviewer;

    // 7. 分配评分专家

    private String userNumberOfMarker;

    // 8. 总分数
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

    // 面向学校专业
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
