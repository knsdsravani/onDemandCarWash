package com.onDemandCarWash.loginManagement.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/logedUser")
	public Principal getUser(Principal user) {
        return user;
    }
}
