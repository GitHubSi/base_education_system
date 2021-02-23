package henu.soft.xiaosi.pojo.declarationform.form2_teachers;

/**
 * Copyright 2021 json.cn
 */

import henu.soft.xiaosi.pojo.declarationform.TeachingCoursesInRecentTwoAcademicYears;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 基层教学组织成员表- 数据
 * Auto-generated: 2021-02-07 12:22:54
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */

/**
 * Copyright 2021 json.cn
 */

/**
 * Auto-generated: 2021-02-07 15:36:7
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeachersData {

    //教师ID
    private String teacherID;
    //姓名
    private String name;
    //出生年月
    private Date birthdate;
    //性别
    private String gender;
    //政治面貌
    private String politicalAffiliation;
    //最终学历（学位）
    private String degree;
    //职称
    private String professionalTitle;
    //行政职务
    private String administrativeDuties;
    //高校教龄
    private int universityTeachingAge;
    //近2学年任教课程及学时
    private List<TeachingCoursesInRecentTwoAcademicYears> teachingCoursesInRecentTwoAcademicYears;


}
