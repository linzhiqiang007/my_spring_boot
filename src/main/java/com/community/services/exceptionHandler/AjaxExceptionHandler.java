package com.community.services.exceptionHandler;

import com.community.services.utils.JSONResultUtil;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class AjaxExceptionHandler {
//	@ExceptionHandler(value = Exception.class)
	public JSONResultUtil defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

		e.printStackTrace();
		return JSONResultUtil.error(e.getMessage());
	}
}
