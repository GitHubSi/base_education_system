package henu.soft.xiaosi.pojo.declarationform;


/**
 * Copyright 2021 json.cn
 */

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 申请表总表
 * Auto-generated: 2021-02-07 13:41:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@Document(collection = "declaration_form")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DeclarationForm {






    // 所属基层教学组织表 ID

    @Id
    private String formID;
    // 申报表审核基本信息
    private FormInfo info;

    // 1. 负责人情况表ID
    private String principalID;

    // 2. 基层教学组织成员
    private String membersID;

    // 3. 规章制度建设表ID
    private String ruleAndRegulationID;

    // 4. 队伍建设表ID
    private String teamBuildingID;

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
    private String futureConstructionPlanID;

    // 13 .教务处反馈意见表ID
    private String opinionFeedbackID;


}
