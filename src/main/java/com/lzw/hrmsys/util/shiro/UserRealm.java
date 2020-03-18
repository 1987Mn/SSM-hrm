package com.lzw.hrmsys.util.shiro;

import com.lzw.hrmsys.domain.User;
import com.lzw.hrmsys.service.UserService;
import com.lzw.hrmsys.util.Encode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;


/**
 * @author STUDY
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User loginUser = (User) subject.getPrincipal();

//        for (Role r:roleService.getRoles(loginUser.getId())) {
//            info.addStringPermissions(r.getPermissions());
//        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        User loginUser = userService.getOneByName(userToken.getUsername());
        if (loginUser == null){
            return null;
        }
        SecurityUtils.getSubject().getSession().setAttribute("loginUser",loginUser);
        String s = Encode.encodByMD5(loginUser.getPassword());
        return new SimpleAuthenticationInfo(loginUser,s,getName());
    }


}
