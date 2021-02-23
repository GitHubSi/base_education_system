package henu.soft.xiaosi.pojo.declarationform.form3_rules_and_regulations;

/**
 * Copyright 2021 json.cn
 */
import lombok.*;

import java.util.Date;

/**
 * 二、规章制度建设表
 * Auto-generated: 2021-02-07 14:42:53
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RulesAndRegulations {

    // 1. 规章制度表ID
    private String id;

    // 2. 创建时间
    private Date createdAt;

    // 3. 更新时间
    private Date updatedAt;

    // 4. 所属申报表ID
    private String formID;

    // 5. 富文本编辑器内容
    private RulesAndRegulationsContent rulesAndRegulationsContent;


}
