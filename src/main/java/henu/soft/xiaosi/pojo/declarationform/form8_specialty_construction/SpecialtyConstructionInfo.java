package henu.soft.xiaosi.pojo.declarationform.form8_specialty_construction;

/**
 * Copyright 2021 json.cn
 */


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 六、专业建设表
 * Auto-generated: 2021-02-07 18:23:36
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
// @Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpecialtyConstructionInfo {
    // 所属基层教学组织表 ID
    private String formID;
    // 专业名称
    private String nameOfSpecialty;
    // 专业认证（时间、组织单位等）
    private String certificationOfSpecialty;
    // 专业评估（时间、组织单位、位次/专业总数等）

    private String evaluationOfSpecialty;
    // 获得特色、综合改革试点专业等称号（时间、等次等）
    private String features;


}
