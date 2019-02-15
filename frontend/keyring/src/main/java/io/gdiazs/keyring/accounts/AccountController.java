package io.gdiazs.keyring.accounts;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.gdiazs.keyring.commons.application.ApplicationLayout;

@Controller
@RequestMapping("/accounts")
public class AccountController extends ApplicationLayout{
	
	

	@GetMapping
	public String index(HttpServletRequest request, Model model) {
		String userName = this.appliactionLayoutService.fetchUsernameFromToken(request);
		model.addAttribute("username", userName);
		
		
		return "accounts/index";
	}
}