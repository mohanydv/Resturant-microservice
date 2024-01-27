package com.mhn.userInfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mhn.userInfo.dto.UserDTO;
import com.mhn.userInfo.entity.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDTO mapUsertoUserDTO(User user);
	User mapUserDtoToUser(UserDTO dto);
	

}
