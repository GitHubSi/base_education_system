package henu.soft.xiaosi.pojo.declarationform;

/**
 * 申报表基本信息
 * Copyright 2021 json.cn
 */

import lombok.*;
import org.springframework.stereotype.Repository;

/**
 * Auto-generated: 2021-02-07 13:41:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormInfo {

    // 1. 教学组织名称
    private String organization;

    //2. 所属学院
    private String college;

    // 3. 负责人
    private String principal;

    // 4. 职称
    private String professionalTitle;

    // 5. 审核状态
    private String status;

    // 6. 审核人
    private String reviewer;

    // 7. 分配评分专家

    private String userNumberOfMarker;

    // 8. 总分数
    private String totalScore;

}
