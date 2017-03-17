package com.study.shopcar.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.shopcar.core.ResultModel;

@RestController
public class ShowSessionController {
	
	@RequestMapping("sessionId")
	public Object sessionId(HttpSession session) {
		String sessionId = session.getId();
		return new ResultModel(true, null, sessionId);
	}
}
