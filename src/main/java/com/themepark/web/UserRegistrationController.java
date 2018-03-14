package com.themepark.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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

import com.themepark.Constants;
import com.themepark.dto.UserRegistrationDto;
import com.themepark.enums.PaymentMode;
import com.themepark.model.AppUser;
import com.themepark.repository.AnnualPassRepository;
import com.themepark.repository.BLAdmissionFeeRepository;
import com.themepark.repository.EntryPackageRepository;
import com.themepark.repository.SingleEntryPassRepository;
import com.themepark.service.AppUserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController implements AccessDeniedHandler {

	@Autowired
	private AppUserService userService;

	@Autowired
	private EntryPackageRepository entryPackageRepository;
	
	@Autowired
	private SingleEntryPassRepository singleEntryPassRepository;
	
	@Autowired
	private AnnualPassRepository annualPassRepository;
	
	@Autowired
	private BLAdmissionFeeRepository blAdmissionFeeRepository;
	
	@Autowired
	private AppUserService appUserService;

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		AppUser appUser = this.appUserService.getLoggedInUser(httpServletRequest.getSession().getAttribute(Constants.LOGGED_IN_USER_ID));
		if (appUser == null) {
			return "redirect:/registration";
		}
		model.addAttribute("packages", this.entryPackageRepository.findAll());
		model.addAttribute("singleEntryPassList", this.singleEntryPassRepository.findAll());
		model.addAttribute("annualPassList", this.annualPassRepository.findAll());
		model.addAttribute("bigLondonAdmissionFeeList", this.blAdmissionFeeRepository.findAll());
		model.addAttribute("paymentModes", PaymentMode.values());
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result,
			RedirectAttributes redirAttrs, @RequestPart("file") final MultipartFile multipartFile,
			HttpServletRequest httpServletRequest) {

		System.out.println("userDto : " + userDto);
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
		
		userService.save(userDto, multipartFile, this.appUserService.getLoggedInUser(httpServletRequest.getSession().getAttribute(Constants.LOGGED_IN_USER_ID)));
		redirAttrs.addFlashAttribute("message", "Form has been saved successfully.");
		return "redirect:/registration";
	}

	@GetMapping(value="/get-reg-users")
	public String getRegisteredUsers() {
		
		return "";
	}
	
	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("error, login req");
		httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
	}
}
