package henu.soft.xiaosi.vo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 前端登录功能user模型实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoUser implements Serializable {


    private String userNumber;
    private String password;
    private String token;

}
