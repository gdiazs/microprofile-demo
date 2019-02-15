package io.gdiazs.keyring.commons.application;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Service
public class AppliactionLayoutService {

	private final String USER_COOKIE = "keyRingJWT";

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Autowired
	private ApplicationMenuOptions menuOptions;

	public ApplicationMenuOption findMenuOptionsById(final String id) {

		final Optional<ApplicationMenuOption> menuOption = menuOptions.getMenus().stream()
				.filter(menu -> menu.getId().equals(id)).findAny();

		menuOption.orElseThrow(() -> new RuntimeException("Menu not found"));

		return menuOption.get();

	}

	public String fetchUsernameFromToken(HttpServletRequest request) {
		String jwt = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(USER_COOKIE)) {
				jwt = cookie.getValue();
			}
		}

		Jws<Claims> jws;
		jws = (Jws<Claims>) Jwts.parser().setSigningKey(Base64.encodeBase64String(jwtSecret.getBytes()))
				.parseClaimsJws(jwt);
		
		return (String) jws.getBody().get("upn");

	}
}
