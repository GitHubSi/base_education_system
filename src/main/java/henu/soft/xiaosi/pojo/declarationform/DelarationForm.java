package henu.soft.xiaosi.pojo.declarationform;


/**
 * Copyright 2021 json.cn
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 申请表总表
 * Auto-generated: 2021-02-07 13:41:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DelarationForm {

    // 所属基层教学组织表 ID
    private String formID;
    // 申报表审核基本信息
    private FormInfo formInfo;




    // 1. 负责人情况表ID
    private String principalID;

    // 2. 基层教学组织成员
    private List<FormTeacher> formTeachers;

    // 3. 规章制度建设表ID
    private String ruleAndRegulationID;

    // 4. 队伍建设表ID
    private String teamBuildingID;

    //private List<> newTeachers;

    // 5. 教学组织表ID
    private String teachingOrganizationID;

    // 6. 课程教材表ID
    private String courseMaterialID;

    // 7. 教学研究表ID
    private String teachingResearchID;

    // 8. 专业建设表ID
    private String specialtyConstructionID;

    // 9. 实践教学表ID
    private String practicalTeachingID;

    // 10. 条件保障表ID
    private String conditionGuaranteeID;

    // 11. 人才培养能力表ID
    private String talentCultivationAbilityID;

    // 12. 今后建设计划表ID
    private String futureConstructionPlan;


}
