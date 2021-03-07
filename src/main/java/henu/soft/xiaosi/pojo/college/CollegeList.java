package henu.soft.xiaosi.pojo.college;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "college")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CollegeList implements Serializable {

    @Id
    private String id;
    private List<String> items;
}
