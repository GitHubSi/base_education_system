package henu.soft.xiaosi.pojo.declarationform.form5_course_material;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TextBooks {
    private String formID;
    private String nameOfTeachingMaterial;
    private String editorInChief;
    private String participatingEditor;
    private String theNumberOfWordsInTheChapter;
    private String yearOfPublication;
    private String press;
    private String level;
}
