package hnu.hxj.sys.controller;

import hnu.hxj.sys.common.ActiverUser;
import hnu.hxj.sys.common.ResultObj;
import hnu.hxj.sys.common.WebUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @RequestMapping("login")
    public ResultObj login(String loginname, String pwd){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(loginname, pwd);
        try{
            subject.login(token);
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            WebUtils.getSession().setAttribute("user",activerUser.getUser());
            return ResultObj.LOGIN_SUCCESS;
        }catch (AuthenticationException e){
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }
    }

}
