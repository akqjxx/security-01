package com.liujc.security01.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {


	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String login(HttpServletRequest request ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			User principal = (User)auth.getPrincipal();
			String username = principal.getUsername();
		}catch (Exception e ){

			return "login";
		}
		return "redirect:/admin/home";
	}


	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("successMessage", "User has been registered successfully");

		modelAndView.setViewName("registration");

		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		modelAndView.addObject("userName", "Welcome " + " " + "");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
}