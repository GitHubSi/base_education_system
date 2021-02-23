package henu.soft.xiaosi.pojo.declarationform.form8_specialty_construction;

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
 * 六、专业建设表
 * Auto-generated: 2021-02-07 18:23:36
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpecialtyConstruction {

    private String id;

    private Date createdAt;

    private Date updatedAt;

    private String formID;

    private SpecialtyConstructionContent specialtyConstructionContent;

    private List<SpecialtyConstructionInfo> specialtyConstructionInfo;


}
