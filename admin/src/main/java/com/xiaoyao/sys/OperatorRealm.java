package com.xiaoyao.sys;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class OperatorRealm extends AbstractUserRealm {

	@Override
	public UserRolesAndPermissions doGetGroupAuthorizationInfo(Operator operator) {
		Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
		userRoles.add("operator");
        userPermissions.add("operator:query");
        // 获取当前用户下拥有的所有角色列表,及权限
        return new UserRolesAndPermissions(userRoles, userPermissions);
	}

	@Override
	public UserRolesAndPermissions doGetRoleAuthorizationInfo(Operator operator) {
		Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
        // 获取当前用户下拥有的所有角色列表,及权限
        return new UserRolesAndPermissions(userRoles, userPermissions);
	}

}
