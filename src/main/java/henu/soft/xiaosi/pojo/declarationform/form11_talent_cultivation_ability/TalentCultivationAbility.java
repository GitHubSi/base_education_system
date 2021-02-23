package henu.soft.xiaosi.pojo.declarationform.form11_talent_cultivation_ability;

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
 * 九、人才培养能力表
 * Auto-generated: 2021-02-07 20:1:14
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TalentCultivationAbility {

    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String formID;
    private TalentCultivationAbilityContent talentCultivationAbilityContent;
    private List<TalentCultivationAbilityInfo> talentCultivationAbilityInfo;
    // 代表性成果(每类5项)
    private Outcome outcome;


}
