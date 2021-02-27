package henu.soft.xiaosi.pojo.declarationform.form7_teaching_research;

/**
 * Copyright 2021 json.cn
 */
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 五、教学研究表-教改项目项
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
public class EducationalReformProjects {
    // 所属基层教学组织表 ID
    private String formID;
    // 教改项目名称
    private String nameOfEducationalReformProject;
    // 立项时间（只显年份）
    private Date timeOfProjectEstablishment;
    // 项目来源
    private String projectSource;
    // 主持人
    private String host;
    // 成员
    private List<String> members;
    // 获奖等次
    private String awards;

}
