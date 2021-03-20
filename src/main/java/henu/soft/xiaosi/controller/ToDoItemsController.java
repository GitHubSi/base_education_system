package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.pojo.todo_list.ToDoItem;
import henu.soft.xiaosi.pojo.todo_list.ToDoList;
import henu.soft.xiaosi.service.ToDoItemsService;
import henu.soft.xiaosi.vo.ResultResponse;
import henu.soft.xiaosi.vo.VoToDoNumbersInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/to-do")
public class ToDoItemsController {

    @Autowired
    ToDoItemsService toDoItemsService;



    /**
     * 1. 查
     */

    @GetMapping("/get-info/{userNumber}")
    public ResultResponse findToDoListByUserNumber(@PathVariable String userNumber){
        ToDoList toDoList = toDoItemsService.getToDoListByUserNumber(userNumber);
        return ResultResponse.success(200,"当前用户待办事项信息获取成功！",toDoList);


    }

    /**
     * 1.1 查
     */

    @GetMapping("/get-numbers-info/{userNumber}")
    public ResultResponse findToDoNumbers(@PathVariable String userNumber){
        VoToDoNumbersInfo toDoNumbersInfo = toDoItemsService.getToDoNumbers(userNumber);
        return ResultResponse.success(200,"当前用户待办事项数量信息获取成功！",toDoNumbersInfo);


    }



    /**
     * 2. 增
     * 用户发起修改请求，或者 申报表的 状态发生修改之后新增代办事项
     */
    @PostMapping("/save-info/{userNumber}")
    public ResultResponse saveToDoItem(@PathVariable String userNumber, @RequestBody ToDoItem toDoItem){
        Boolean result = toDoItemsService.saveToDoItem(userNumber, toDoItem);
        if(result){
            return ResultResponse.success(200,"新增一个代办事项成功！",null);
        }
        return ResultResponse.success(404,"新增一个代办事项失败！",null);

    }

    /**
     * 3. 删
     * 用户直接点击待办项处理，用户处理之后，删除该项代办事项
     */
    @DeleteMapping("/delete-info/{userNumber}")
    public ResultResponse deleteToDoItem(@PathVariable String userNumber, @RequestBody ToDoItem toDoItem){
        Boolean result = toDoItemsService.deleteToDoItem(userNumber, toDoItem);
        if(result){
            return ResultResponse.success(200,"删除一个待办事项成功！",null);
        }
        return ResultResponse.success(404,"删除一个待办事项失败！",null);

    }



}
