package henu.soft.xiaosi.pojo.declarationform.form7_teaching_research;

/**
 * Copyright 2021 json.cn
 */

import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 五、教学研究表-教改论文项
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
public class TeachingResearchPapers {
    // 所属基层教学组织表 ID
    private String formID;
    // 教研论文名称
    private String nameOfTeachingResearchPaper;
    // 发表时间（年月）
    private Date publishedTime;
    // 期刊名称
    private String journalName;
    // 第一作者
    private String authorInChef;


}
