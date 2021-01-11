package hnu.hxj.sys.controller;

import hnu.hxj.sys.common.ActiverUser;
import hnu.hxj.sys.common.ResultObj;
import hnu.hxj.sys.common.WebUtils;
import hnu.hxj.sys.entity.Loginfo;
import hnu.hxj.sys.service.ILoginfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private ILoginfoService loginfoService;

    @RequestMapping("login")
    public ResultObj login(String loginname, String pwd){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(loginname, pwd);
        try{
            subject.login(token);
            ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
            WebUtils.getSession().setAttribute("user",activerUser.getUser());

            Loginfo loginfo = new Loginfo();
            loginfo.setLoginname(activerUser.getUser().getName()+"-"+activerUser.getUser().getLoginname());
            loginfo.setLoginip(WebUtils.getRequest().getRemoteAddr());
            loginfo.setLogintime(new Date());
            loginfoService.save(loginfo);

            return ResultObj.LOGIN_SUCCESS;
        }catch (AuthenticationException e){
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }
    }

}
