package henu.soft.xiaosi.pojo.declarationform.form7_teaching_research;

/**
 * Copyright 2021 json.cn
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 五、教学研究表- 代表性校外教学研讨会
 * Auto-generated: 2021-02-07 18:0:33
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RepresentativeOffCampusTeachingSeminars {
    // 所属基层教学组织表 ID
    private String formID;
    // 时间（只显年份）
    private Date time;
    // 地点
    private String place;
    // 内容
    private String content;
    // 主办单位
    private String organizer;
    // 参加人员
    private String participants;


}
