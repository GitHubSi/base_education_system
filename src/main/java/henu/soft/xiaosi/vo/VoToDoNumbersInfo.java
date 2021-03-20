package henu.soft.xiaosi.vo;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VoToDoNumbersInfo {
    //  待审核的备案表数量
    private int  numbersOfPriview;
    // 待评阅的备案表数量
     private int numbersOfMarker;
    // 待分配的备案表数量
    private int numbersOfDispatch;
}
