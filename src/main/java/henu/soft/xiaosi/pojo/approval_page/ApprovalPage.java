package henu.soft.xiaosi.pojo.approval_page;

/**
 * Copyright 2021 json.cn
 */
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 总申报表信息展示-总申报表审核列表
 * Auto-generated: 2021-02-07 12:22:54
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Document("approval_page")
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApprovalPage {


    @Id
    private String id;


    // 申请表详细信息
    private List<Data> data;

}

