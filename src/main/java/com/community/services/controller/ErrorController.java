package com.community.services.controller;

import com.community.services.utils.JSONResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 错误页面的测试
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("err")
public class ErrorController {
	@RequestMapping("/error")
	public String error() {
		int a = 1 / 0;
		return "thymeleaf/error";
	}

	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		return "thymeleaf/ajaxerror";
	}

	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public JSONResultUtil getAjaxerror() {
		int a = 1 / 0;
		return JSONResultUtil.ok();
	}
}
