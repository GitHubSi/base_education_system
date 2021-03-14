package henu.soft.xiaosi.pojo.declarationform.form1_principal;

/**
 * Copyright 2021 json.cn
 */
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * 1. 负责人情况表
 * Auto-generated: 2021-02-07 14:17:39
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Principal {



    @Id
    private String principalID;

    // 教学组织名称
    private String nameOfTeachingOrganization;
    // 隶属单位
    private String subordinateUnit;

    // 类别
    private String classification;

    // 获批等级
    private ApprovalLevel approvalLevel;

    private String name;
    private Date birthdate;
    private String gender;
    private String politicalAffiliation;
    private String degree;
    private String authorizationDepartment;
    private Date dateOfGrant;
    private int universityTeachingAge;
    private String professionalTitle;
    private String administrativeDuties;
    private Date dateOfHeadOfBasicTeachingOrganization;
    private String postAllowance;
    private List<TeachingCoursesInRecentTwoAcademicYears> teachingCoursesInRecentTwoAcademicYears;
    private String averageAnnualTeachingWorkloadAndReductionRatio;
    private String mainTeachingAchievements;


}
