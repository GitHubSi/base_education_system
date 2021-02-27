package henu.soft.xiaosi.pojo.declarationform.form2_teachers;

/**
 * Copyright 2021 json.cn
 */

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * 基层教学组织成员- 教师实体类
 * Auto-generated: 2021-02-07 14:26:23
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Document(collection = "form2_teachers")
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Teachers {


    @Id
    private String membersID;
    private int count;
    private TeachersPagination teachersPagination;
    private List<TeachersData> data;

}
