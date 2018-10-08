package com.druid.realm;


import com.druid.entity.DruidUser;
import com.druid.service.DruidUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class UserRealm extends AuthorizingRealm{
	@Autowired
	private DruidUserService druidUserService;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userRealm";
	}
		
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub

		String username = token.getPrincipal().toString();

		Example example = new Example(DruidUser.class);
		example.createCriteria().andEqualTo("username", username);

		List<DruidUser> druidUserList = druidUserService.selectByExample(example);
		if (druidUserList.size() !=1 ) return null;
		DruidUser druidUser = druidUserList.get(0);
		String pwd = druidUser.getPassword();

		//ByteSource credentialsSalt = ByteSource.Util.bytes(druidUser.getSalt());//使用账号作为盐值
		return new SimpleAuthenticationInfo(username, pwd,getName());
	}
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
}
