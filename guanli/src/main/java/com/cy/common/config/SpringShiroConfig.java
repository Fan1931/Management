package com.cy.common.config;

import com.cy.yan.service.realm.ShiroUserRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置文件
 */
@Configuration
public class SpringShiroConfig {

    /**
     * 单机环境，session交给shiro管理
     */
    @Bean
    public DefaultWebSessionManager newSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionValidationInterval(3600 * 1000);
        sessionManager.setGlobalSessionTimeout(3600 * 1000);
        return sessionManager;
    }

    @Bean("securityManager")
    public SecurityManager newSecurityManager(ShiroUserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(newSessionManager());
        securityManager.setRememberMeManager(newRememberMeManager());
        securityManager.setCacheManager(newCacheManager());
        return securityManager;
    }

    public RememberMeManager newRememberMeManager() {
        CookieRememberMeManager cManager = new CookieRememberMeManager();
        cManager.setCookie(newCookie());
        return cManager;
    }

    public SimpleCookie newCookie() {
        SimpleCookie sc = new SimpleCookie("simpleCookie");
        sc.setMaxAge(7 * 24 * 60 * 60);
        return sc;
    }

    public CacheManager newCacheManager() {
        MemoryConstrainedCacheManager cacheManager = new MemoryConstrainedCacheManager();
        return cacheManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setUnauthorizedUrl("/");
        shiroFilter.setLoginUrl("/doRegisterUI");  //无权限时跳转
        shiroFilter.setSuccessUrl("/doLogin");
        /*
        anon 无需认证可以访问
        authc 认证之后可以访问
        perms 必须拥有某个权限才可以访问
        role 拥有某个角色才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/bower_components/**", "anon");
        filterMap.put("/build/**", "anon");
        filterMap.put("/dist/**", "anon");
        filterMap.put("/plugins/**", "anon");
        filterMap.put("/yUser/doLogin", "anon");
        filterMap.put("/Logout", "logout");
        filterMap.put("/yUser/regist", "anon");
 //       filterMap.put("/**", "authc");

        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    /**
     * DefaultAdvisorAutoProxyCreator相当于一个切面
     * AuthorizationAttributeSourceAdvisor相当于切点
     *
     * AdvisorAutoProxyCreator，代理生成器，
     * 需要借助SpringAOP来扫描@RequiresRoles和@RequiresPermissions等注解，
     * 生成代理类实现功能增强，从而实现权限控制。
     * 需要配合AuthorizationAttributeSourceAdvisor一起使用，否则权限注解无效。
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator newProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
