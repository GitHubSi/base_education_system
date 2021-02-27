package henu.soft.xiaosi.pojo.declarationform.form13_opinion_feedback;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "form13_opinion_feedback")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpinionFeedback {


    @Id
    private String opinionFeedbackID;
    private OpinionFeedbackContent content;
}
