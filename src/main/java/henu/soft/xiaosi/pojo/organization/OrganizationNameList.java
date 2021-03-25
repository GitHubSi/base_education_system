package henu.soft.xiaosi.pojo.organization;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "organization_name")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationNameList {

    @Id
    private String id;

    private List<String> names;

}
