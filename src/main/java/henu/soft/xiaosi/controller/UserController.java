package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.pojo.user.User;
import henu.soft.xiaosi.service.UserService;
import henu.soft.xiaosi.vo.ListQuery;
import henu.soft.xiaosi.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    /**
     * 1. 获取用户列表
     * @return
     */
    @PostMapping("/list")
    public ResultResponse findUserList(@RequestBody ListQuery listQuery){

        List<User> userList = userService.findUserList(listQuery);
        return ResultResponse.success(200,"用户列表获取成功！",userList);

    }

    /**
     * 2. 查：查找用户
     * @param userNumber
     * @return
     */
    @GetMapping("/detail/{userNumber}")
    public ResultResponse findUserByUserNumber(@PathVariable String userNumber){
        return null;
    }

    /**
     * 3. 增 ：增加用户
     * @param user
     * @return
     */

    @PostMapping("/create")
    public ResultResponse saveUser(@RequestBody User user){
        Boolean result = userService.saveUser(user);
        if(result){
            return ResultResponse.success(200,"新增用户成功！",null);
        }
        return ResultResponse.fail(404,"新增用户失败！",null);
    }

    /**
     * 4. 删：删除用户
     * @param userNumber
     * @return
     */
    @DeleteMapping("/delete/{userNumber}")
    public ResultResponse deleteUserByUserNumber(@PathVariable String userNumber){
        Boolean result = userService.deleteUserByUserNumber(userNumber);
        if(result){
            return ResultResponse.success(200,"删除用户成功！",null);
        }
        return ResultResponse.fail(404,"删除用户失败！",null);

    }

    /**
     * 5. 更新：更新用户
     * @param userNumber
     * @param user
     * @return
     */
    @PostMapping("/update/{userNumber}")
    public ResultResponse updateUserByUserNumber(@PathVariable String userNumber,@RequestBody User user){
        Boolean result = userService.updateUserBuyUserNumber(userNumber, user);
        if(result){
            return ResultResponse.success(200,"更新用户成功！",null);
        }
        return ResultResponse.fail(404,"更新用户失败！",null);
    }



}
