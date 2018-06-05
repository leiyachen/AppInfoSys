package cn.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.app.pojo.BackendUser;
import cn.app.tools.Constants;

public class BackInterceptor extends HandlerInterceptorAdapter{
	private Logger logger=Logger.getLogger(BackInterceptor.class);
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		logger.debug("BackInterceptor preHandle!");
		HttpSession session=request.getSession();
		BackendUser backUser=(BackendUser)session.getAttribute(Constants.BACKUSER_SESSION);
		if(null==backUser){
			response.sendRedirect(request.getContextPath()+"/403.jsp");
			return false;
		}
		return true;
	}
}
