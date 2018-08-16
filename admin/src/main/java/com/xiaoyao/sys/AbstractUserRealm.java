package com.xiaoyao.sys;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import sys.Log;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractUserRealm extends AuthorizingRealm {

    @Autowired
    private OperatorService operatorService;
    //获取用户组的权限信息
    public abstract UserRolesAndPermissions doGetGroupAuthorizationInfo(Operator operator);
    //获取用户角色的权限信息
    public abstract UserRolesAndPermissions doGetRoleAuthorizationInfo(Operator operator);

    /**
     * 获取授权信息，判断用户是否拥有某个权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String currentLoginName = (String) principals.getPrimaryPrincipal();
        Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
        //从数据库中获取当前登录用户的详细信息
        Operator operator = operatorService.findByOperatorName(currentLoginName);
        if (null != operator) {
            UserRolesAndPermissions groupContainer = doGetGroupAuthorizationInfo(operator);
            UserRolesAndPermissions roleContainer = doGetGroupAuthorizationInfo(operator);
            userRoles.addAll(groupContainer.getUserRoles());
            userRoles.addAll(roleContainer.getUserRoles());
            userPermissions.addAll(groupContainer.getUserPermissions());
            userPermissions.addAll(roleContainer.getUserPermissions());
        } else {
            throw new AuthorizationException();
        }
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(userRoles);
        authorizationInfo.addStringPermissions(userPermissions);
        Log.info(String.format("###【获取角色成功】[SessionId] =>%s",SecurityUtils.getSubject().getSession().getId()),this.getClass());
        return authorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        Operator operator= operatorService.findByOperatorName(token.getUsername());
        if (operator != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            return new SimpleAuthenticationInfo(operator.getSoperatorname(),operator.getSpassword() , getName());
        }
        return null;
    }

    protected class UserRolesAndPermissions {
        Set<String> userRoles;
        Set<String> userPermissions;

        public UserRolesAndPermissions(Set<String> userRoles, Set<String> userPermissions) {
            this.userRoles = userRoles;
            this.userPermissions = userPermissions;
        }

        public Set<String> getUserRoles() {
            return userRoles;
        }

        public Set<String> getUserPermissions() {
            return userPermissions;
        }




    }
    
}