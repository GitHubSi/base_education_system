package henu.soft.xiaosi.pojo.approval_page;

/**
 * Copyright 2021 json.cn
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 总申报表信息展示-申报表审核情况 数据
 * Auto-generated: 2021-02-07 12:22:54
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {

    // 1. 申报表ID

    private String formID;

    // 基层教学组织管理员的userNumber

    private String userNumber;

    // 2. 组织名称
    private String organization;

    // 3. 所属学院
    private String college;

    // 4. 负责人
    private String principal;

    // 5. 职称
    private String professionalTitle;

    // 6. 审核状态
    private String status;

    // 7. 审核人
    private String reviewer;


    private String userNumberOfReviewer;


    // 9. 评测人工号
    private String userNumberOfMarker;

    // 10. 总分数

    private String totalScore;


}
