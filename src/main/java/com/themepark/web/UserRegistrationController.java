package com.themepark.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.themepark.repository.AppUserRepository;
import com.themepark.service.AppUserService;
import com.themepark.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private AppUserService userService;

	@Autowired
	private AppUserRepository appUserRepository;

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
			@RequestPart("file") final MultipartFile multipartFile, BindingResult result, RedirectAttributes redirAttrs) {

		/*AppUser existing = userService.findByEmail(userDto.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}*/
		for (FieldError e : result.getFieldErrors()) {
			System.out.println("result.hasErrors() : " + e.getField());

		}
		if (result.hasErrors()) {
			return "registration";
		}
		userService.save(userDto, multipartFile);
		redirAttrs.addFlashAttribute("message", "Form has been saved successfully.");
		return "redirect:/registration";
	}
}
