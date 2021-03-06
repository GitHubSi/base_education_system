package henu.soft.xiaosi.pojo.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

//把一个java类声明为mongodb的文档，可以通过collection参数指定这个类对应的文档。
//@Document(collection="mongodb 对应 collection 名")
// 若未加 @Document ，该 bean save 到 mongo 的 comment collection
// 若添加 @Document ，则 save 到 comment collection
@Document(collection="user")//可以省略，如果省略，则默认使用类名小写映射集合
public class User implements Serializable {

    @Id
    private String id;
    private String userNumber;
    private String username;

    private String password;
    private String college;
    private String role;


}
