package com.stores.stores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path =  "/")
public class InicioController {
	
	@GetMapping()
	public String Index() {
		return "Api vitrix success";
	}

}
