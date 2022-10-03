package com.PruebaGlobalhitss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PruebaGlobalhitss.entity.Users;
import com.PruebaGlobalhitss.exception.UsersNotFoundException;
import com.PruebaGlobalhitss.service.UsersService;

@RestController
@RequestMapping("/usuario")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping(path = "/create")
	public ResponseEntity<String> createUser(@RequestBody Users user) {
	
		Users userNew = usersService.save(user);
		return new ResponseEntity<String>("Usuario es creado correctamente con el id = " +userNew.getId(), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id") int id, @RequestBody Users user) {

		boolean isUserExist = usersService.isUsersExist(id);
		if(isUserExist) {
			user.setId(id);
			usersService.update(user);
			return new ResponseEntity<String>("Usuario es actualizado correctamente", HttpStatus.CREATED);
		}else {
			
			throw new UsersNotFoundException();
		}
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Users>> getUser(@PathVariable("id") int id) {
	
		boolean isUserExist = usersService.isUsersExist(id);
		if(isUserExist) {
			Optional<Users> userGet = usersService.getUser(id);
			return new ResponseEntity<Optional<Users>>(userGet, HttpStatus.OK);
		}else {
			
			throw new UsersNotFoundException();
		}
		
	}
	
	@GetMapping(path = "/all")
    public ResponseEntity<List<Users>> getAll(){
        return new ResponseEntity<List<Users>>(usersService.getAll(), HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
	
		boolean isUserExist = usersService.isUsersExist(id);
		if(isUserExist) {
			usersService.delete(id);
			return new ResponseEntity<String>("Usuario es eliminado correctamente", HttpStatus.OK);
		}else {
			
			throw new UsersNotFoundException();
		}
		
	}
	
}
