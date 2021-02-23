package henu.soft.xiaosi.pojo.forms;

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
 * 总申报表信息展示-申报表审核情况 页码信息
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
public class Pagination {

    // 1. 当前页码
    private int page;

    // 2. 每页数据量
    private int perPage;


}
