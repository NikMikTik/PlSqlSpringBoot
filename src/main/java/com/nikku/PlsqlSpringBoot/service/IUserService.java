package com.nikku.PlsqlSpringBoot.service;

import java.util.List;

import com.nikku.PlsqlSpringBoot.dto.ResponseDto;
import com.nikku.PlsqlSpringBoot.dto.UserDto;
import com.nikku.PlsqlSpringBoot.model.User;

public interface IUserService {
	 public List<UserDto> getAllUsers();

	public ResponseDto registrationFunction(UserDto userDto);

}
