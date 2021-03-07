package henu.soft.xiaosi.vo;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListQuery implements Serializable {
    private int page;
    private int limit;
    private String college;
    private String role;

    private String queryUsername;
    private String queryRole;
    private String queryCollege;

}
