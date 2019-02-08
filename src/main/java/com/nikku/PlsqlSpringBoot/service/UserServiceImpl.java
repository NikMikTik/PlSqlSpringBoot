package com.nikku.PlsqlSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nikku.PlsqlSpringBoot.dto.ResponseDto;
import com.nikku.PlsqlSpringBoot.dto.UserDto;
import com.nikku.PlsqlSpringBoot.model.User;
import com.nikku.PlsqlSpringBoot.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@PersistenceContext
	private EntityManager em;

	ModelMapper modelMapper = new ModelMapper();
	ResponseDto response=new ResponseDto();

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> getAllUsers() {
		StoredProcedureQuery findAll = em.createNamedStoredProcedureQuery("getAllUsers_procedure");
		List<UserDto> userDtoList = new ArrayList<>();
		UserDto userDto;

		List<User> userList = findAll.getResultList();
		for (User user : userList) {
			userDto = modelMapper.map(user, UserDto.class);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	@Override
	public ResponseDto registrationFunction(UserDto userDto) {
		if ((userRepository.findByEmail(userDto.getEmail()) == null)) {
			User user = modelMapper.map(userDto, User.class);
			userRepository.save(user);
			response.setCode(HttpStatus.OK.value());
			response.setMessage("User successfully logged In");
			response.setResponse("Access Given");
			return response;
		}
		else {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("User cannot log In");
			response.setResponse("Access Not Given");
			return response;
		}
		
	
	}

}
