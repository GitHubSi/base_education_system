package henu.soft.xiaosi.pojo.forms;

/**
 * Copyright 2021 json.cn
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 总申报表信息展示-总申报表审核列表
 * Auto-generated: 2021-02-07 12:22:54
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DelarationForms  {

    // 申请表总表数量
    private int count;

    // 页码信息
    private Pagination pagination;

    // 申请表详细信息
    private List<Data> data;

}

