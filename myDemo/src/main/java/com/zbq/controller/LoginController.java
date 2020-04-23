package com.zbq.controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.zbq.model.entity.resp.ResponsePara;

@RestController
public class LoginController {
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class); 
	
    @GetMapping("/login")
    public ModelAndView login(){
    	ModelAndView view=new ModelAndView("login1.html");
    	view.setViewName("login1.html");
        return view;
 
    }

    
    
    @RequestMapping(value = "/doLogin1", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResponsePara ajaxLogin(String username, String password) {
    	ResponsePara response=new ResponsePara();
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
      UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
            response.setRtnCode("000000");
            response.setRtnMsg("登陆成功");
            response.setToken(subject.getSession().getId());
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        	response.setRtnCode("999999");
        	response.setRtnMsg( "密码错误");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        	response.setRtnCode("111111");
            response.setRtnMsg( "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
    @RequestMapping(value = "/doLogin", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ModelAndView ajaxLogin1(String username, String password) {
        ModelAndView modelAndView = new ModelAndView("index.html");
        ResponsePara response=new ResponsePara();
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
            response.setRtnCode("000000");
            response.setRtnMsg("登陆成功");
            response.setToken(subject.getSession().getId());
            if(SecurityUtils.getSubject().isAuthenticated()) {
                modelAndView.setViewName("index.html");
                return modelAndView;
            }
        } catch (IncorrectCredentialsException e) {
            if(SecurityUtils.getSubject().isAuthenticated()) {
                modelAndView.setViewName("erro.html");
                return modelAndView;
            }
            jsonObject.put("msg", "密码错误");
            response.setRtnCode("999999");
            response.setRtnMsg( "密码错误");
            return  modelAndView;
        } catch (AuthenticationException e) {
            if(SecurityUtils.getSubject().isAuthenticated()) {
                modelAndView.setViewName("erro.html");
                return modelAndView;
            }
            jsonObject.put("msg", "该用户不存在");
            response.setRtnCode("111111");
            response.setRtnMsg( "该用户不存在");
            return  modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }

    //错误页面展示
    @GetMapping("/error")
    public String error(){
        return "error ok!";
    }

}