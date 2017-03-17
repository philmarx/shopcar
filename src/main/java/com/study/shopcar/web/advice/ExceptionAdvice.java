package com.study.shopcar.web.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.study.shopcar.core.ResultModel;

@ControllerAdvice
public class ExceptionAdvice {
	private static Log log = LogFactory.getLog(ExceptionAdvice.class);

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public Object exception(Exception e, WebRequest webRequest) {
		log.error(e.getMessage());
		return new ResultModel(false, e.getMessage(), e);
	}
}
