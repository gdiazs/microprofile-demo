package io.gdiazs.keyring.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {

	@Value("${users.endpoint}")
	private String accountEndpoint;

	public String doLogin(String user, String password) {
		RestTemplate restTemplate = new RestTemplate();
		String jwt = "";
		StringBuilder url = new StringBuilder(accountEndpoint);
		url.append("/auth");

		AuthenticationLoginDto login = new AuthenticationLoginDto(user, password);
		ResponseEntity<AuthenticationTokenResponseDto> postForEntity = restTemplate.postForEntity(url.toString(), login, AuthenticationTokenResponseDto.class);
	
		if(postForEntity.getStatusCode().equals(HttpStatus.OK)) {
			 jwt = postForEntity.getBody().getToken();
		}
		
		return jwt;
	}
	
	

}
