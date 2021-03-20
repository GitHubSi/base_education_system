package henu.soft.xiaosi.pojo.todo_list;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "todo_list")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoList {
    private String id;
    private String userNumber;
    private List<ToDoItem> toDoItems;

}
