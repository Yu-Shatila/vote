package com.xxy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class Magnetometer extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("我是谁?"+handler);
		//HttpSession session = request.getSession();
		String uri = request.getRequestURI();
 		System.out.println("uri:"+uri);
		/*
		 * if(uri.endsWith("user")) { return true; }
		 *
		 * User u = (User)session.getAttribute("user"); if(u==null) {
		 * response.sendRedirect("login.htm"); return false; }
		 */
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("拦截器当场去世...(((m-__-)m");
	}
	
}
