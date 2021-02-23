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
import java.util.List;

/**
 * 五、教学研究表
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
public class TeachingResearch {
    // 教学研究表ID
    private String id;
    // 创建时间
    private Date createdAt;
    // 更新时间
    private Date updatedAt;
    // 申报表ID
    private String formID;
    // 富文本编辑器内容
    private TeachingResearchContent teachingResearchContent;
    // 教改项目项
    private List<EducationalReformProjects> educationalReformProjects;
    // 教改论文项
    private List<TeachingResearchPapers> teachingResearchPapers;
    // 代表性教研活动(5次)
    private List<RepresentativeTeachingAndResearchActivities> representativeTeachingAndResearchActivities;
    // 代表性校外教学研讨会(5次)
    private List<RepresentativeOffCampusTeachingSeminars> representativeOffCampusTeachingSeminars;


}
