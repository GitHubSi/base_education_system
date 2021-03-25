package henu.soft.xiaosi.pojo.declarationform.form1_principal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApprovalLevel {

    // 省级合格获批时间
    private String provincialQualificationOfTime;

    // 省级优秀获批时间
    private String provincialExcellenceOfTime;
}
