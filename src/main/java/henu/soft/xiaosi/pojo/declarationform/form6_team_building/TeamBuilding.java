package henu.soft.xiaosi.pojo.declarationform.form6_team_building;

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
 * Auto-generated: 2021-02-07 20:16:17
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamBuilding {

    private String id;
    private Date createdAt;
    private Date updateAt;
    private String fromID;
    private TeamBuildingContent teamBuildingContent;
    private String nameOfNewTeacher;
    private int trainingTime;
    private String trainingPlace;
    private String trainingInstitution;
    private String supervisor;
    private String professionalTitle;


}
