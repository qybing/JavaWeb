package com.bank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String  url = request.getRequestURI();
        System.out.println("======================");
        System.out.println("url:"+url);
        //如果是登录提交地址，则放行
        if (url.indexOf("login.do")>=0){
            return  true;
        }
        Object teller = request.getSession().getAttribute("teller");

        System.out.println("teller :"+teller);
        if(teller!=null && !teller.equals("")){
            return  true;
        }
        request.getRequestDispatcher("/error.jsp").forward(request,response);
        return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
