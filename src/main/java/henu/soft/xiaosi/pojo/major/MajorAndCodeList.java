package henu.soft.xiaosi.pojo.major;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "major_and_code")
public class MajorAndCodeList {

    @Id
    private String id;
    private List<MajorAndCodeItem> majors;
}
