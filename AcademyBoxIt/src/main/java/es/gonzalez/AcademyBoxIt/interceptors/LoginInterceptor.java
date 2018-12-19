package es.gonzalez.AcademyBoxIt.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.gonzalez.AcademyBoxIt.model.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "/login.jsp";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean cond= false;
		String uri = request.getRequestURI();
		User user = (User) request.getSession().getAttribute("sessionUser");
		if(user == null){
		if (!uri.endsWith("/login.jsp")&&(!uri.endsWith("/index.jsp")&&(!uri.endsWith("/")))){ //Autorizadas sin autenticar
		//Redirigir al inicio en caso de acceso prohibido
		response.sendRedirect(request.getContextPath() + LOGIN);
		} else {
			cond=true;
		}
		
		}
		return cond;

	}
}
