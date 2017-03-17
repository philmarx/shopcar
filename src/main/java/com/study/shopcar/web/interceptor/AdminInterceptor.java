package com.study.shopcar.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.study.shopcar.core.Keys;
import com.study.shopcar.core.Role;
import com.study.shopcar.dmo.User;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	public AdminInterceptor() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Keys.loginData);
		if (user == null) {
			return false;
		}
		if (user.getRole().equals(Role.管理员.name())) {
			return true;
		}
		return false;
	}
}
