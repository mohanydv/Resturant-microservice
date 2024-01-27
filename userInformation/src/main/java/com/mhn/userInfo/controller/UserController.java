package com.mhn.userInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mhn.userInfo.dto.UserDTO;
import com.mhn.userInfo.service.UserService;

import jakarta.ws.rs.POST;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto) {

		UserDTO savedUser = service.addUser(dto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

	}

	@GetMapping("/fetchUserById/{userId}")
	ResponseEntity<UserDTO> fetchUserDetailsByID(@PathVariable Integer userId) {
		return service.featchUserById(userId);

	}

}
