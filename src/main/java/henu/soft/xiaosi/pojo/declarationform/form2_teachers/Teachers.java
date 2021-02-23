package henu.soft.xiaosi.pojo.declarationform.form2_teachers;

/**
 * Copyright 2021 json.cn
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * 基层教学组织成员- 教师实体类
 * Auto-generated: 2021-02-07 14:26:23
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teachers {

    private int count;
    private TeachersPagination teachersPagination;
    private List<TeachersData> data;

}
