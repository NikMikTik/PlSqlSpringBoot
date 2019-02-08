package com.nikku.PlsqlSpringBoot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nikku.PlsqlSpringBoot.dto.ResponseDto;
import com.nikku.PlsqlSpringBoot.dto.UserDto;
import com.nikku.PlsqlSpringBoot.model.User;
import com.nikku.PlsqlSpringBoot.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	ModelMapper modelMapper = new ModelMapper();

	// GET ALL USERS LIST
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List<UserDto> retrieveAllUsers(HttpServletRequest request) {
		return userService.getAllUsers();
	}

	// SIGNUP
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ResponseDto signUp(@RequestBody UserDto userDto) {
		User merchant = modelMapper.map(userDto, User.class);
		return userService.registrationFunction(userDto);

	}

}
