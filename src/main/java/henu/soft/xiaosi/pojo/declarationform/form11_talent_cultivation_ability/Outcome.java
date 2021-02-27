package henu.soft.xiaosi.pojo.declarationform.form11_talent_cultivation_ability;

/**
 * Copyright 2021 json.cn
 */

import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 九、人才培养能力-成果表
 * Auto-generated: 2021-02-07 20:1:14
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Outcome {

    private String formID;
    // 学科竞赛
    private String subjectCompetition;
    // 职业技能大赛
    private String professionalSkillsCompetition;
    // 互联网+创业大赛
    private String internetPlusEntrepreneurshipContest;
    // 创新创业情况
    private String innovationAndEntrepreneurship;
    // 发表论文
    private String publishTheses;


}
