package henu.soft.xiaosi.controller;

import henu.soft.xiaosi.pojo.user.User;
import henu.soft.xiaosi.service.LoginService;
import henu.soft.xiaosi.utils.JwtUtil;
import henu.soft.xiaosi.vo.ResultResponse;
import henu.soft.xiaosi.vo.VoUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    /***
     * 1. 用户登录
     * @param voUser
     * @param
     * @param httpServletResponse
     * @return
     */

    @PostMapping("/login")
    public ResultResponse login(@RequestBody VoUser voUser, HttpServletResponse httpServletResponse){

        String currentUserNumber = voUser.getUserNumber();
        String currentUserPassword = voUser.getPassword();
        System.out.println("debug=>"+ currentUserNumber + currentUserPassword);

        // 用户不存在
        User findUser = loginService.findUserByUserNumber(currentUserNumber);
        System.out.println(findUser);
        if(findUser == null){
            return ResultResponse.fail(401,"用户不存在！",null);
        }
        // 密码不正确
        if(!findUser.getPassword().equals(currentUserPassword)){
            return ResultResponse.fail(401,"用户密码错误！",null);
        }
        // 生成token,返回前端
        String token = JwtUtil.createToken(currentUserNumber);
        httpServletResponse.setHeader("Access-Control-Expose-Headers","token");
        httpServletResponse.setHeader("token",token);

        voUser.setToken(token);
        return ResultResponse.success(200,"正在登录...！",voUser);


    }

    /***
     * 2. 获取用户信息
     * @param httpServletRequest
     * @return
     */

    @GetMapping("/info")
    public ResultResponse userInfo(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        if(token == null) {
            return ResultResponse.success(200,"请重新登录！",null);
        }
        String userNumber = JwtUtil.getUserNumber(token);

        User currentUser = loginService.findUserByUserNumber(userNumber);
        return ResultResponse.success(200,"获取用户信息成功！",currentUser);


    }

    /**
     * 退出功能
     * @return
     */

    @RequiresAuthentication
    @PostMapping("/logout")
    public  ResultResponse logout(){
        SecurityUtils.getSubject().logout();
        return ResultResponse.success(200,"退出成功！",null);
    }

}
