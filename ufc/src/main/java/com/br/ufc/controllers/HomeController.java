package com.br.ufc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{

	  @GetMapping("/login")
	  public String login() {
	    return "login"; // <<< Retorna a página de login
	  }
	   
	  @GetMapping("/")
	  public String index() {
	    return "index";
	  }
	  @GetMapping("")
	  public String index2() {
	    return "index";
	  }
	  @RequestMapping("/")
	  public String index3() {
	    return "index";
	  }
	  
}
