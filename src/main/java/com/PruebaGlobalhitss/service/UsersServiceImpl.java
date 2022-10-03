package com.PruebaGlobalhitss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PruebaGlobalhitss.entity.Users;
import com.PruebaGlobalhitss.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAll() {
		return (List<Users>) usersRepository.findAll();
	}

	public Optional<Users> getUser(int id) {
		Optional<Users> optional = usersRepository.findById(id);
		Users user = optional.get();
		return Optional.ofNullable(user);
	}

	public Users save(Users users) {
		return usersRepository.save(users);
	}

	public void delete(int id) {
		usersRepository.deleteById(id);
		
	}

	public boolean isUsersExist(int id) {
		return usersRepository.existsById(id);
	}

	public void update(Users users) {
		usersRepository.save(users);
		
	}

	
}
