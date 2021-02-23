package henu.soft.xiaosi.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;


import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    private ShiroFilter shiroFilter;

    //1. session共享管理,需要开启redis服务
    @Bean
    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

        sessionManager.setSessionDAO(redisSessionDAO);

        return sessionManager;
    }

    // 2. session管理
    @Bean
    public SessionsSecurityManager sessionsSecurityManager(UserRealm userRealm,
                                                           SessionManager sessionManager,
                                                           RedisCacheManager redisCacheManager
                                                           ){
        //关联Realm对象
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(userRealm);

        securityManager.setSessionManager(sessionManager);
        securityManager.setCacheManager(redisCacheManager);
        return securityManager;
    }

    //3.用户

    //3.1Shiro过滤链定义,哪些链接需要经过哪些过滤器
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        Map<String,String> filterMap = new LinkedHashMap<>();

        //所有的链接都需要经过过滤器
        filterMap.put("/**","jwt");//主要经过注解的方式授权

        chainDefinition.addPathDefinitions(filterMap);

        return chainDefinition;
    }
    //3.2shiro过滤器工厂，装配过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
                                                         ShiroFilterChainDefinition shiroFilterChainDefinition){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();


        //给拦截器设置安全管理器
        shiroFilter.setSecurityManager(securityManager);


        //1. 添加内置过滤器
        //设置未登录认证拦截器
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/**","jwt");
        shiroFilter.setFilterChainDefinitionMap(filterMap);



        //2. 设置自定义权限拦截器

        Map<String, Filter> filters = new HashMap<>();
        filters.put("jwt", this.shiroFilter);
        shiroFilter.setFilters(filters);


        //设置登录的请求,返回未登录的信息给前端
        //shiroFilter.setLoginUrl("/notLogin");

        //未授权访问跳转页面，点击有权限的页面，会自动指定UserRealm的方法
        //shiroFilter.setUnauthorizedUrl("/notPermission");
        return shiroFilter;
    }





}
