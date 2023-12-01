package com.mftplus.javaee04.model.service;

import com.mftplus.javaee04.controller.exception.AccessDeniedException;
import com.mftplus.javaee04.controller.exception.DuplicateUserException;
import com.mftplus.javaee04.model.entity.User;
import com.mftplus.javaee04.model.repository.CrudRepository;
import com.mftplus.javaee04.model.service.impl.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements Service<User,String> {
    private static UserService service = new UserService();

    private UserService() {
    }

    public  static UserService getService() {
        return service;
    }

    @Override
    public User save(User user) throws Exception {
        try(CrudRepository<User, String> repository = new CrudRepository<>()){
            if(findByUsername(user.getUsername())==null){
                return repository.save(user);
            }else{
                throw  new DuplicateUserException("Username is already taken");
            }
        }
    }

    @Override
    public User edit(User user) throws Exception {
        try(CrudRepository<User, String> repository = new CrudRepository<>()){
            return repository.edit(user);
        }
    }

    @Override
    public User remove(String id) throws Exception {
        try(CrudRepository<User, String> repository = new CrudRepository<>()){
            return repository.remove(User.class, id);
        }
    }

    @Override
    public List<User> findAll() throws Exception {
        try(CrudRepository<User, String> repository = new CrudRepository<>()){
            return repository.findAll(User.class);
        }
    }

    @Override
    public User findById(String id) throws Exception {
        return findByUsername(id);
    }

    public User findByUsername(String username) throws Exception{
        try(CrudRepository<User, String> repository = new CrudRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("username", username);
            List<User> userList = repository.findBy("User.FindByUsername", params);
            return (userList.isEmpty())? null: userList.get(0);
        }
    }

    public User findByUsernameAndPassword(String username,String password) throws Exception{
        try(CrudRepository<User, String> repository = new CrudRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            List<User> userList = repository.findBy("User.FindByUsernameAndPassword", params);
            if (userList.isEmpty()){
                throw new AccessDeniedException("Wrong Username/Password");
            }
            return userList.get(0);
        }
    }
}
