package henu.soft.xiaosi.pojo.declarationform.form5_course_material;

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
 * 四、课程教材概述
 * Auto-generated: 2021-02-07 17:52:19
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseMaterial {

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
    private CourseMaterialContent courseMaterialContent;
    private List<CourseMaterialInfo> courseMaterialInfo;


}
