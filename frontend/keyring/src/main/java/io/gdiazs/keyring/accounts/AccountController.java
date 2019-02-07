package io.gdiazs.keyring.accounts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.gdiazs.keyring.commons.application.ApplicationLayout;

@Controller
@RequestMapping("/accounts")
public class AccountController extends ApplicationLayout{
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping
	public String index() {
		return "accounts/index";
	}
}