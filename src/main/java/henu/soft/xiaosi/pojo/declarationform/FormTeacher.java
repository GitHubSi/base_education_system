package henu.soft.xiaosi.pojo.declarationform;

/**
 * Copyright 2021 json.cn
 */

import lombok.*;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

/**
 * 基层教学组织成员
 * Auto-generated: 2021-02-07 12:8:42
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormTeacher {

    private String teacherID;
    private String name;
    private Date birthdate;
    private String gender;
    private String politicalAffiliation;
    private String degree;
    private String professionalTitle;
    private String administrativeDuties;
    private int universityTeachingAge;
    private List<TeachingCoursesInRecentTwoAcademicYears> teachingCoursesInRecentTwoAcademicYears;


}
