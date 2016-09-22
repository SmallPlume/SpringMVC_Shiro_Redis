package com.modules.sys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.redis.web.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modules.sys.dto.Result;
import com.modules.sys.entity.User;
import com.modules.sys.service.UserService;

@Controller
public class SysCTRL {
	
	@Autowired
	private RedisClientTemplate template;
	
	@Autowired
	private UserService service;

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model){
		System.out.println("aa======"+template.get("aa"));
		
		List<User> list = service.queryUser();
		model.addAttribute("list",list);
		return "index";
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		template.set("aa", "10086");
		return "login";
	}
	
	/**
	 * 登录
	 * @param request
	 * @param model
	 */
	@RequestMapping(value = "/login", method=RequestMethod.POST)
    public @ResponseBody Result submitLoginForm(User user,HttpServletRequest request,Model model) {
        String errorClassName = (String) request.getAttribute("shiroLoginFailure");
        if (UnknownAccountException.class.getName().equals(errorClassName)) {
            return Result.error("用户名/密码错误");
        } else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
            return Result.error("用户名/密码错误");
        } else if (errorClassName != null) {
            return Result.error("未知错误：" + errorClassName);
        }
        return Result.ok("登录成功");
    }
	
	/**
	 * 登出
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(){
		Subject subject=SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	
	@RequestMapping(value="/unauthor",method=RequestMethod.GET)
	public String unauthor(){
		return "unauthor";
	}
	
	/**===================**/
	
	/**
	 * 只有查看权限才能查看
	 */
	@RequiresPermissions("user:view")
	@RequestMapping(value="/user/view",method=RequestMethod.GET)
	public String userView(){
		System.out.println("==========view==========");
		return "user/userView";
	}
	
	
	/**
	 * 只有查看权限才能查看
	 */
	@RequiresPermissions("user:edit")
	@RequestMapping(value="/user/edit",method=RequestMethod.GET)
	public String userEdit(){
		System.out.println("==========edit==========");
		return "user/userEdit";
	}
	
	
	
}