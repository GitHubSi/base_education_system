package henu.soft.xiaosi.pojo.declarationform.form12_future_construction_plan;

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
 * 十、今后建设计划表
 * Auto-generated: 2021-02-07 20:9:16
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FutureConstructionPlan {

    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String formID;
    private FutureConstructionPlanContent futureConstructionPlanContent;


}
