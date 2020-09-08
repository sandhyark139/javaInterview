package com.example.helloworld;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {
@Autowired
	private MessageSource messageSource;
	@GetMapping(path="/hello")
	public String world()
	{
		return "Hello Sandy";
	}
	/*@GetMapping(path="/hello-i18n")
	public String i18n(@RequestHeader(name="Accept-Language",required=false) Locale locale)
	{
		
		return messageSource.getMessage("good.morning.message",null,locale);
				
				
	}*/
	
	@GetMapping(path="/hello-i18n")
	public String i18n(@RequestHeader(name="Accept-Language",required=false) Locale locale)
	{
		//return "Hello Sandy i18n app";
		return messageSource.getMessage("good.morning.message",null,locale);
		
	}
}
