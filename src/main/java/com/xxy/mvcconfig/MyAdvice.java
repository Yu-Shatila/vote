package com.xxy.mvcconfig;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class MyAdvice {
	
	//@ExceptionHandler(Exception.class)
	public String doException(Exception e, Model model) {
		e.printStackTrace();
		System.out.println("error: " + e.getMessage()+"");
		model.addAttribute("meg",e.getMessage());
		return "error";
	}

}
