package com.example.infra.oauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);
	
	private final OAuth2RestTemplate oAuth2RestTemplate;
	
	public GreetingController(OAuth2RestTemplate oAuth2RestTemplate) {
		this.oAuth2RestTemplate=oAuth2RestTemplate;
	}
	
	@GetMapping()
	public ModelAndView init(Model model) {
		return new ModelAndView("home");
	}
	
	@PostMapping("/request")
	public ModelAndView greeting(RedirectAttributes redirectAttributes) {
		
		LOGGER.info("/greeting/request has started");
		
		String message = "";
		
		try {
			
			LOGGER.info("Invoking {}",String.format("http://localhost:%d/api/hello", 9090));
			
			message = oAuth2RestTemplate.getForObject(String.format("http://localhost:%d/api/hello", 9090), String.class);
			
			LOGGER.info("Response: {}",message);
	        
		}catch(Exception ex) {
			LOGGER.error("greeting exception: {}",ex.getMessage(),ex);
			message=ex.getMessage();
		}
		
		redirectAttributes.addFlashAttribute("message",message);

		return new ModelAndView("redirect:/greeting");
		
	}
}
