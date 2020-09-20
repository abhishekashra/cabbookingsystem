/**
 * 
 */
package com.abhishek.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MainController for loading the view pages
 * 
 * @author abhishek
 *
 */
@Controller
public class MainController {

	@RequestMapping("/")
    public String home() {
        return "index";
    }
	
	 @RequestMapping("/next")
	    public String next(Map<String, Object> model) {
	        model.put("message", "You are in new page !!");
	        return "next";
	    }

	@GetMapping("/partials/{page}")
	public String partialHandler(@PathVariable("page") final String page) {
		return page;
	}

	@GetMapping("/error")
	public String error() {
		return "Error Occured";
	}

}
