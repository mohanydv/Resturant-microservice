package com.mhn.userInfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mhn.userInfo.dto.UserDTO;
import com.mhn.userInfo.entity.User;
import com.mhn.userInfo.mapper.UserMapper;
import com.mhn.userInfo.service.repoitory.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDTO addUser(UserDTO dto) {

		User user = repository.save(UserMapper.INSTANCE.mapUserDtoToUser(dto));
		return UserMapper.INSTANCE.mapUsertoUserDTO(user);
	}

	@Override
	public ResponseEntity<UserDTO> featchUserById(Integer userId) {
		Optional<User> fetchUser = repository.findById(userId);
		if (fetchUser.isPresent()) {

			return new ResponseEntity<UserDTO>(UserMapper.INSTANCE.mapUsertoUserDTO(fetchUser.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
