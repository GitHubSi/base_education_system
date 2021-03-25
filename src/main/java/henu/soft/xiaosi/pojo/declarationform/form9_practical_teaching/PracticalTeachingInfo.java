package henu.soft.xiaosi.pojo.declarationform.form9_practical_teaching;

/**
 * Copyright 2021 json.cn
 */

import lombok.*;

/**
 * 七、实践教学
 * Auto-generated: 2021-02-07 19:42:24
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PracticalTeachingInfo {

    private String formID;
    // 校内实践（实验、实训）单位名称
    private String nameOfSchoolPracticalUnit;
    // 使用面积
    private int area;
    // 校内实践教学工位数
    private int numberOfPracticeTeachingInSchool;
    // 承接实践课程数
    private String experimentalCourses;
    // 实践学生人数/学年
    private int numberOfPracticeStudents;


}
