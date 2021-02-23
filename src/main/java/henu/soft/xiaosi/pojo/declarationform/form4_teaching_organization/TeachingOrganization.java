package henu.soft.xiaosi.pojo.declarationform.form4_teaching_organization;

/**
 * Copyright 2021 json.cn
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 三、获取教学组织表
 * Auto-generated: 2021-02-07 17:44:31
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeachingOrganization {

    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String formID;
    private int totalNumberOfTeachers;
    private int coursesUndertaken;
    private int perCapitaWeeklySchoolHours;
    private int perCapitaGuidingGraduationThesis;
    private int teachingAccident;
    private String comprehensiveEvaluationOfExcellentTeaching;
    private TeachingOrganizationContent teachingOrganizationContent;
    private List<TeachingOrganizationInfo> teachingOrganizationInfo;

}
