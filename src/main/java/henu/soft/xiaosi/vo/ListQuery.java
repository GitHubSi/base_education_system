package henu.soft.xiaosi.vo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 *  用户管理模块  权限限制
 *  需要根据当前用户角色实现 分层分配
 */

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
