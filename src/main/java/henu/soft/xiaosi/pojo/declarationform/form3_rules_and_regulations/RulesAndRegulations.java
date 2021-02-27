package henu.soft.xiaosi.pojo.declarationform.form3_rules_and_regulations;

/**
 * Copyright 2021 json.cn
 */
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 二、规章制度建设表
 * Auto-generated: 2021-02-07 14:42:53
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Document(collection = "form3_rules_and_regulations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RulesAndRegulations {



    // 1 所属申报表ID
    @Id
    private String  ruleAndRegulationID;


    // 2. 富文本编辑器内容
    private RulesAndRegulationsContent content;


}
