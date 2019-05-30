package top.keepmoving.kmweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.keepmoving.kmweb.domain.User;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-03-07
 * <p>@Description:
 */
@Controller
public class CommonController {

	private static final String BASE_PATH = "common/";

	@GetMapping("/login")
	public String login() {
		return BASE_PATH + "login";
	}

	@GetMapping("/register")
	public String toRegister() {
		return BASE_PATH + "register";
	}

	@PostMapping("/register")
	public String register(User user) {
		return "redirect:/index";
	}

	@GetMapping("/404")
	public String error404() {
		return BASE_PATH + "404";
	}

	@GetMapping("/500")
	public String error500() {
		return BASE_PATH + "500";
	}
}
