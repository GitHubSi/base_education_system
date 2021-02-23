package henu.soft.xiaosi.pojo.declarationform.form2_teachers;

/**
 * Copyright 2021 json.cn
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

/**
 * 基层教学组织成员表- 页码信息
 * Auto-generated: 2021-02-07 12:22:54
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeachersPagination {

    // 1. 当前页码
    private int page;

    // 2. 每页数据量
    private int perPage;


}
