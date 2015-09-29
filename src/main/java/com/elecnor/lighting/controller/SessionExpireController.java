package com.elecnor.lighting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionExpireController {

	@RequestMapping("/sessionExpire")
	public String getSessionExpirePage() {
		return "sessionExpire";
	}
	
	@RequestMapping("/errorPage")
	public String getErrorPage() {
		return "error";
	}
	
	@RequestMapping("/getUnAuthenticatedPage")
	public String getUnAuthenticatedPage() {
		return "unAuthenticatedPage";
	}
	
}
