package henu.soft.xiaosi.shiro;

import cn.hutool.json.JSONUtil;
import henu.soft.xiaosi.utils.JwtUtil;
import henu.soft.xiaosi.vo.ResultResponse;

import lombok.SneakyThrows;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Shiro过滤器
 */

@Component
public class ShiroFilter extends AuthenticatingFilter {

    /**
     * 0. 处理跨域请求，因为访问CrosConfig之前先访问 过滤器
     * @param request
     * @param response
     * @param
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");


        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {

            httpServletResponse.setStatus(org.springframework.http.HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }



    /**
     *  1. 访问资源执行此方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String jwt = httpServletRequest.getHeader("token");

        // 无token，直接放行，在Controller产生token
        // 在header中是否存在jwt,不存在未登录直接放行，使用注解拦截
        if(jwt == null){
            return true;

        }
        //存在
        else{
            //执行校验token是否过期

            if(!JwtUtil.verify(jwt, JwtUtil.getUserNumber(jwt))){



                throw new ExpiredCredentialsException("token已经失效，请重新登录！");
            }
            //执行登录

            return executeLogin(request,response);
        }

    }
    /**
     * 2. executeLogin 登录认证方法调用该方法,登录认证的时候需要从Headers取出来token,不存在的话直接返回null
     *
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String jwt = httpServletRequest.getHeader("token");

        if("".equals(jwt)){
            return null;
        }

        return new ShiroToken(jwt);
    }


    /**
     * 3. 登录认证失败 返回前端失败的json
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @SneakyThrows
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        //转化response对象，便于返回给前端数据
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //失败信息
        Throwable throwable = e.getCause() == null ? e : e.getCause();
        ResultResponse result = ResultResponse.fail(403,throwable.getMessage(),null);

        //转化为json对象
        String json = JSONUtil.toJsonStr(result);

        //打印错误信息
        httpServletResponse.getWriter().print(json);

        System.out.println("登录失败了！");

        return false;

    }



}
