package com.xxy.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        System.out.println("创建过滤器....................");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("过滤器当场去世....................");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	/**
	 * @see 初始化
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器开始起飞..............");
	}

}
