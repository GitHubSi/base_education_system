package henu.soft.xiaosi.pojo.declarationform.form8_specialty_construction;

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
 * 六、专业建设表
 * Auto-generated: 2021-02-07 18:23:36
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@Document(collection = "form8_speciality_construction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpecialtyConstruction {




    private Date createdAt;

    private Date updatedAt;
    @Id
    private String specialtyConstructionID;

    private SpecialtyConstructionContent content;

    private SpecialtyConstructionInfo info;


}
