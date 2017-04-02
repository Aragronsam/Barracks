package com.binaryhunter.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 跨域过滤器
 * @author BinaryHunter
 *
 */
public class CorsFilter implements Filter{

	private static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
	private static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
	private static final String METHODS_NAME = "Access-Control-Allow-Methods";
	private static final String HEADERS_NAME = "Access-Control-Allow-Headers";
	private static final String MAX_AGE_NAME = "Access-Control-Max-Age";
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res; 
        response.setHeader(CREDENTIALS_NAME, "true");
		response.setHeader(ORIGIN_NAME, "*");
		response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
		response.setHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Access-Control-Allow-Origin, Accept");
		response.setHeader(MAX_AGE_NAME, "3600");
        
        if(!"options".equalsIgnoreCase(((HttpServletRequest)req).getMethod())){
        	chain.doFilter(req, res); 
        }
    }

    @Override
    public void destroy() {
    }

}