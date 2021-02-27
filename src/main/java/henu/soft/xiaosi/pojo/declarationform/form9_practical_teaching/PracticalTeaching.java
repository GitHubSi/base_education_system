package henu.soft.xiaosi.pojo.declarationform.form9_practical_teaching;

/**
 * Copyright 2021 json.cn
 */
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * 七、实践教学
 * Auto-generated: 2021-02-07 19:42:24
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@Document(collection = "form9_practical_teaching")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PracticalTeaching {



    private Date createdAt;
    private Date updatedAt;
    @Id
    private String practicalTeachingID;
    private PracticalTeachingContent content;
    private List<PracticalTeachingInfo> info;


}
