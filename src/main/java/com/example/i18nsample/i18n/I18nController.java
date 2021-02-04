package com.example.i18nsample.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class I18nController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/international")
	public String getInternationalPage(HttpServletRequest request, Model model) {

Locale locale = RequestContextUtils.getLocale(request);
		System.out.println(locale);
		
		model.addAttribute("i18n_message_from_controller", messageSource.getMessage("placeholder.message", null, locale));
		
		return "international";
	}

}
