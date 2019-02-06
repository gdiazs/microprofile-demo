package io.gdiazs.keyring.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.gdiazs.keyring.commons.application.ApplicationLayout;

@Controller
public class HomeController extends ApplicationLayout{

	@GetMapping("/")
	public String index() {
	
		return "home/index";
	}
}
