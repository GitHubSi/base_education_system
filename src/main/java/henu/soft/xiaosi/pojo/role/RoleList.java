package henu.soft.xiaosi.pojo.role;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleList implements Serializable {

    @Id
    private String id;
    private String currentRole;
    private List<String> items;
}
