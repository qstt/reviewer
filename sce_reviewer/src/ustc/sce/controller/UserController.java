package ustc.sce.controller;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import ustc.sce.authorization.TokenManager;
import ustc.sce.domain.Token;
import ustc.sce.response.Response;
import ustc.sce.service.UserService;
import ustc.sce.utils.TokenUtil;

/**
 * 用户控制层    登录 注册
 * @author 秋色天堂
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="tokenManager")
	private TokenManager tokenManager;
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@RequestParam("userName") String userName,@RequestParam("userPassword") String userPassword,HttpServletResponse response,HttpServletRequest request) {
		Token tk = new Token();
		boolean flag = userService.login(userName, userPassword);
		if (flag) {
			String token = tokenManager.createToken(userName);
			Cookie cookie = new Cookie("X-Token", token);
			response.addCookie(cookie);
			tk.setUserName(userName);
			tk.setToken(token);
			return JSON.toJSONString(new Response().success(tk));
		}
		return JSON.toJSONString(new Response().failure("Login Failure..."));
	}

	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(@RequestParam("userName") String userName,@RequestParam("userPassword") String userPassword,@RequestParam("roleName") String roleName,HttpServletRequest request) {
		boolean flag = userService.register(userName,userPassword,roleName);
		if (flag) {
			return JSON.toJSONString(new Response().success("Register Success..."));
		}
		return JSON.toJSONString(new Response().failure("Register Failure..."));
	}

}
