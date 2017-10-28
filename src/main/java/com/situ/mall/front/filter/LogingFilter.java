package com.situ.mall.front.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.mall.pojo.User;

/**
 * Servlet Filter implementation class LogingFilter
 */
public class LogingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String requestURI = req.getRequestURI();
		System.out.println(requestURI);
		if (requestURI != null && requestURI.startsWith(req.getContextPath()+"/order")) {
			HttpSession session = req.getSession();
			if (null != session) {
				User user = (User) session.getAttribute("user");
				if(null != user){
				chain.doFilter(request, response);
				return ;
				} else {
					resp.sendRedirect(req.getContextPath() + "/login/login.shtml");
					return;
				}
			} else {
				resp.sendRedirect(req.getContextPath()+"/login/login.shtml");
				return;
			}
		} 
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
