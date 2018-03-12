package com.themepark.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.themepark.repository.AppUserRepository;

@Controller
public class MainController {
	
	@Autowired
	private AppUserRepository appUserRepository;

    @GetMapping("/")
    public String root() {
    		System.out.println("inside method");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
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
