package henu.soft.xiaosi.pojo.declarationform.form6_team_building;

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
 * Auto-generated: 2021-02-07 20:16:17
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Document(collection = "form6_team_building")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeamBuilding {



    @Id
    private String teamBuildingID;
    private List<NewTeachers> newTeachers;
    private TeamBuildingContent content;


}
