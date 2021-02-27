package henu.soft.xiaosi.pojo.declarationform.form7_teaching_research;

/**
 * Copyright 2021 json.cn
 */

import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 五、教学研究表-代表性教研活动5次
 * Auto-generated: 2021-02-07 18:0:33
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RepresentativeTeachingAndResearchActivities {
    // 所属基层教学组织表 ID
    private String formID;
    // 时间（年月日）
    private Date time;
    // 地点
    private String place;
    // 内容
    private String content;
    // 主持人
    private String host;
    // 主持人职务
    private String hostPosition;
    // 参加人员
    private String participants;


}
