package com.mhn.userInfo.service;

import org.springframework.http.ResponseEntity;

import com.mhn.userInfo.dto.UserDTO;

public interface UserService {


	UserDTO addUser(UserDTO dto);

	ResponseEntity<UserDTO> featchUserById(Integer userId);

}
