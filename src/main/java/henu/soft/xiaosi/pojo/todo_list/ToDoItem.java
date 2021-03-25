package henu.soft.xiaosi.pojo.todo_list;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoItem {
    // 代办事项标题
    private String title;
    // 代办表ID
    private String formID;

    private String createTime;


}
