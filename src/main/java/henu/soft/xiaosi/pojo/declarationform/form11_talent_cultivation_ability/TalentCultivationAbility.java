package henu.soft.xiaosi.pojo.declarationform.form11_talent_cultivation_ability;

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
 * 九、人才培养能力表
 * Auto-generated: 2021-02-07 20:1:14
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@Document(collection = "form11_talent_cultivation_ability")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TalentCultivationAbility {



    private Date createdAt;
    private Date updatedAt;
    @Id
    private String talentCultivationAbilityID;
    private TalentCultivationAbilityContent content;
    private List<TalentCultivationAbilityInfo> info;
    // 代表性成果(每类5项)
    private Outcome outcome;


}
