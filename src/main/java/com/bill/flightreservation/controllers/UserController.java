package com.bill.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bill.flightreservation.entities.User;
import com.bill.flightreservation.repos.UserRepository;
import com.bill.flightreservation.services.SecurityService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityService securityService;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {

		return "login/registerUser";

	}

	@PostMapping("/registerUser")
	public String register(@ModelAttribute("user") User user) {
        user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);

		return "login/login";

	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email,
			@RequestParam("password")String password,ModelMap modelMap) {
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "findFlights";
		}else {
			modelMap.addAttribute("msg","invalid username or password,please try again.");
		}
		return "login/login";
	}

}
