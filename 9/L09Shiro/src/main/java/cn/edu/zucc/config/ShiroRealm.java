package cn.edu.zucc.config;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.Admin;
import cn.edu.zucc.entity.SysPermission;
import cn.edu.zucc.entity.SysRole;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class ShiroRealm extends AuthorizingRealm {
    @Resource
    private AdminDao adminDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Admin adminInfo = (Admin) principals.getPrimaryPrincipal();

        for (SysRole role : adminInfo.getRoleList()) {
            info.addRole(role.getRole());
            for (SysPermission p : role.getPermissions()) {
                info.addStringPermission(p.getPermission());
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());

        Admin adminInfo = adminDao.findByUsername(username);

        if (adminInfo == null) {
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                adminInfo,
                adminInfo.getPassword(),
                ByteSource.Util.bytes(adminInfo.getCredentialsSalt()),
                getName()
        );
        return info;
    }

}