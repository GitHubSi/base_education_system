package henu.soft.xiaosi.pojo.declarationform.form10_condition_guarantee;

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
 * 八、条件保证表
 * Auto-generated: 2021-02-07 19:54:20
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConditionGuarantee {

    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String formID;
    private ConditionGuaranteeContent conditionGuaranteeContent;
    private ConditionGuaranteeInfo conditionGuaranteeInfo;


}
