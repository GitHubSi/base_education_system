package henu.soft.xiaosi.shiro;

import henu.soft.xiaosi.pojo.user.User;
import henu.soft.xiaosi.service.LoginService;
import henu.soft.xiaosi.utils.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRealm extends AuthorizingRealm {



    @Autowired
    LoginService loginService;




    @Override
    public boolean supports(AuthenticationToken token) {
        //判断JwtToken便于下面强转
        return token instanceof ShiroToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();


        //拿出来user表中Role字段为当前用户添加角色
        info.addRole(currentUser.getRole());
        return info;

    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {



        ShiroToken shiroToken = (ShiroToken) authenticationToken;


        String currentUserNumber = JwtUtil.getUserNumber(shiroToken.getToken());

        User currentUser = loginService.findUserByUsername(currentUserNumber);

        if(currentUser == null){
            throw new UnknownAccountException("用户名不存在！");
        }


        return new SimpleAuthenticationInfo(currentUser, shiroToken.getCredentials(),getName());

    }
}
