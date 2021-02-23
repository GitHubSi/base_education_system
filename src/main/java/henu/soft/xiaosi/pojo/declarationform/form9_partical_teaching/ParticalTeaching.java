package henu.soft.xiaosi.pojo.declarationform.form9_partical_teaching;

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
 * 七、实践教学
 * Auto-generated: 2021-02-07 19:42:24
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticalTeaching {

    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String formID;
    private ParticalTeachingContent particalTeachingContent;
    private List<ParticalTeachingInfo> particalTeachingInfo;


}
