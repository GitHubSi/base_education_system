package henu.soft.xiaosi.pojo.declarationform.form5_course_material;

/**
 * Copyright 2021 json.cn
 */
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
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
@Data
@Document(collection = "form5_course_material")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseMaterial {



    private Date createdAt;
    private Date updatedAt;
    @Id
    private String courseMaterialID;
    private CourseMaterialContent content;

    private List<OnlineCourses> onlineCourses;
    private List<TextBooks> textbooks;


}
