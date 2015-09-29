package com.elecnor.lighting.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

public class ElecnorInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// If Request url is not of login, then only check session and valid
		// user
		if (!request.getRequestURI().equals("/ElecnorFMS/login")
				&& !request.getRequestURI().equals("/ElecnorFMS")
				&& !request.getRequestURI().equals("/ElecnorFMS/")
				&& !request.getRequestURI().contains("/ElecnorFMS/errorPage")
				&& !request.getRequestURI().contains("/ElecnorFMS/getUnAuthenticatedPage")
				&& !request.getRequestURI().contains("assets")) {
			// If Session Is empty or user is not logged in -- then redirecting
			// the request to home page
			HttpSession session = request.getSession(false);
			if (session == null || session.getAttribute("selectedUser") == null) {
				ModelAndView mv = new ModelAndView("sessionExpire");
				ModelAndViewDefiningException mvde = new ModelAndViewDefiningException(
						mv);
				throw mvde;
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
