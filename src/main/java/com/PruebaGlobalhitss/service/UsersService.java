package com.PruebaGlobalhitss.service;

import java.util.List;
import java.util.Optional;

import com.PruebaGlobalhitss.entity.Users;

public interface UsersService {

    public List<Users> getAll();
    public Optional<Users> getUser(int id);
    public Users save(Users users);
    public void delete(int id);
    public void update(Users users);
    public abstract boolean isUsersExist(int id);
    
}
