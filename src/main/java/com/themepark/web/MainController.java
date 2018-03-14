package com.themepark.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.themepark.Constants;
import com.themepark.dto.LoginDto;
import com.themepark.enums.Role;
import com.themepark.model.AppUser;
import com.themepark.repository.AppUserRepository;
import com.themepark.service.AppUserService;


@Controller
public class MainController {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppUserService appUserService;

	@ModelAttribute("login")
	public LoginDto loginDto() {
		return new LoginDto();
	}

	@GetMapping("/")
	public String loginForm(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		AppUser appUser = this.appUserService.getLoggedInUser(httpSession.getAttribute(Constants.LOGGED_IN_USER_ID));
		if (appUser != null) {
			if (appUser.getRole().equals(Role.SUPER_ADMIN)) {
				model.addAttribute("registeredUsers", this.appUserService.getRegisteredUsers());
			}
			return "index";
		}
		
		return "login";
	}

	@GetMapping("/login")
	public String loginPage(Model model,
			RedirectAttributes redirAttrs, HttpServletRequest httpServletRequest) {
		AppUser appUser = this.appUserService.getLoggedInUser(httpServletRequest.getSession().getAttribute(Constants.LOGGED_IN_USER_ID));
		if (appUser == null) {
			redirAttrs.addFlashAttribute("loginError", "Please login to access.");
			return "redirect:/";
		}
		
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute(Constants.LOGGED_IN_USER_ID, appUser.getId());
		
		if (appUser.getRole().equals(Role.SUPER_ADMIN)) {
			model.addAttribute("registeredUsers", this.appUserService.getRegisteredUsers());
		}
		
		return "index";
	}
	
	@PostMapping("/login")
	public String login(Model model, @ModelAttribute("login") @Valid LoginDto loginDto, BindingResult result,
			RedirectAttributes redirAttrs, HttpServletRequest request, HttpServletResponse response) {
		AppUser appUser = this.appUserService.validateUser(loginDto);
		System.out.println("appuser : " + appUser);
		if (appUser == null) {
			redirAttrs.addFlashAttribute("loginError", "Please enter valid credentials!");
			return "redirect:/";
		}
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute(Constants.LOGGED_IN_USER_ID, appUser.getId());
		
		if (appUser.getRole().equals(Role.SUPER_ADMIN)) {
			model.addAttribute("registeredUsers", this.appUserService.getRegisteredUsers());
		}
		
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute(Constants.LOGGED_IN_USER_ID);
		return "redirect:/";
	}
	

	@GetMapping(value = "/get-file/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public HttpEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {

		byte[] bytes = this.appUserRepository.findOne(id).getAvatar();
		System.out.println(bytes.length);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new HttpEntity<byte[]>(bytes, headers);
	}
}
