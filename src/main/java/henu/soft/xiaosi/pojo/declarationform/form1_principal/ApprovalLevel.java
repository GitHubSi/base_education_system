package henu.soft.xiaosi.pojo.declarationform.form1_principal;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApprovalLevel {

    // 省级合格获批时间
    private Date provincialQualificationOfTime;

    // 省级优秀获批时间
    private Date provincialExcellenceOfTime;
}
