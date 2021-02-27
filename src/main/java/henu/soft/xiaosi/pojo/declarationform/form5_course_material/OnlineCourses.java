package henu.soft.xiaosi.pojo.declarationform.form5_course_material;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnlineCourses {

    private String formID;
    private String onlineCourseName;
    private String platformSite;
    private int chosenNumbers;
    private int period;
    private Date completionTime;
    private String level;
}