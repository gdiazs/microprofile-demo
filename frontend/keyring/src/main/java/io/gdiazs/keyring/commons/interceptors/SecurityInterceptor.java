package io.gdiazs.keyring.commons.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	private final String USER_COOKIE = "keyRingJWT";

	/**
	 * Valida que la cookie del navegador tenga el almenos un token
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		String jwt = "";

		String requestURI = request.getRequestURI();

		if (requestURI.contains("/keyring/login") || requestURI.contains("resources")
				|| requestURI.contains("errors")) {
			return true;
		}

		if (cookies == null) {
			response.sendRedirect("/keyring/login");
			return false;

		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(USER_COOKIE)) {
					jwt = cookie.getValue();
				}
			}
			request.setAttribute("jwt", jwt);
		}

		return true;

	}

}
