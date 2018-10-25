package com.itheima.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.core.po.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		String url=arg0.getRequestURI();
		//���˵�½��action�⣬������Ҫ����
		if(url.indexOf("/login.action")>=0) {
			return true;
		}
		//��ȡsession
		HttpSession session = arg0.getSession();
		User user = (User)session.getAttribute("USER_SESSION");
		if(user!=null) {
			return true;
		}
		arg0.setAttribute("msg", "����û�е�½�����ȵ�½��");
		arg0.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(arg0, arg1);
		return false;
	}

}
