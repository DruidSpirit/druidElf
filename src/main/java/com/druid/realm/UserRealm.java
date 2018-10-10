package com.druid.realm;


import com.druid.entity.DruidSecurityRolePermission;
import com.druid.entity.DruidUser;
import com.druid.service.DruidUserService;
import com.druid.service.RolePermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm{
	@Autowired
	private DruidUserService druidUserService;
	@Autowired
	private RolePermissionService rolePermissionService;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userRealm";
	}
		
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken userToken = (UsernamePasswordToken) token;

		String username = userToken.getUsername();

		Example example = new Example(DruidUser.class);
		example.createCriteria().andEqualTo("username", username);

		List<DruidUser> druidUserList = druidUserService.selectByExample(example);
		if (druidUserList.size() !=1 ) return null;
		DruidUser druidUser = druidUserList.get(0);
		String pwd = druidUser.getPassword();

		ByteSource credentialsSalt = ByteSource.Util.bytes(druidUser.getSalt());//使用盐值
		return new SimpleAuthenticationInfo(druidUser, pwd,credentialsSalt,getName());
	}
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		DruidUser druidUser = (DruidUser) principals.getPrimaryPrincipal();
		Example example = new Example(DruidSecurityRolePermission.class);
		example.createCriteria().andEqualTo("roleId", druidUser.getRoleId());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<DruidSecurityRolePermission> druidSecurityRolePermissionList = rolePermissionService.selectByExample(example);

		if (druidSecurityRolePermissionList == null || druidSecurityRolePermissionList.size()<=0) return null;
		for (DruidSecurityRolePermission druidSecurityRolePermission:druidSecurityRolePermissionList) {
			info.addStringPermission(druidSecurityRolePermission.getPermission());
		}
		return info;
	}

}
