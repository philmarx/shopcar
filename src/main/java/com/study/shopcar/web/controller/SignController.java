package com.study.shopcar.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.shopcar.core.Keys;
import com.study.shopcar.core.MD5Util;
import com.study.shopcar.core.ResultModel;
import com.study.shopcar.core.Role;
import com.study.shopcar.dao.UserDao;
import com.study.shopcar.dmo.User;

@RestController
@RequestMapping("sign")
public class SignController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("up")
	public Object register(String email, String password) {
		User user = new User();
		user.setPassword(MD5Util.getSecurityCode(password));
		user.setUsername(email);
		user.setRole(Role.买家.name());
		this.userDao.save(user);
		return new ResultModel(true, null, null);
	}

	@RequestMapping("in")
	public Object login(String username, String password, HttpSession session) throws Exception {
		User user = this.userDao.findByUsername(username);
		if (user == null) {
			throw new Exception("用户名不存在或密码错误");
		}
		if (!user.getPassword().equals(MD5Util.getSecurityCode(password))) {
			throw new Exception("用户名不存在或密码错误");
		}
		session.setAttribute(Keys.loginData, user);
		return new ResultModel(true, null, user);
	}
	@RequestMapping("in/admin")
	public Object loginAdmin(String username, String password, HttpSession session) throws Exception {
		User user = this.userDao.findByUsername(username);
		if (user == null) {
			throw new Exception("用户名不存在或密码错误");
		}
		if (!user.getPassword().equals(MD5Util.getSecurityCode(password))) {
			throw new Exception("用户名不存在或密码错误");
		}
		if (!user.getRole().equals(Role.管理员.name())) {
			throw new Exception("您没有管理员权限");
		}
		session.setAttribute(Keys.loginData, user);
		return new ResultModel(true, null, user);
	}
}
