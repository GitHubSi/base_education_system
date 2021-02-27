package henu.soft.xiaosi.pojo.declarationform.form10_condition_guarantee;

/**
 * Copyright 2021 json.cn
 */

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 八、条件保证表
 * Auto-generated: 2021-02-07 19:54:20
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Document(collection = "form10_condition_guarantee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConditionGuarantee {



    private Date createdAt;
    private Date updatedAt;
    @Id
    private String conditionGuaranteeID;
    private ConditionGuaranteeContent content;
    private ConditionGuaranteeInfo info;


}
