package com.gustavodealmeida.workshopmongo.services;

import com.gustavodealmeida.workshopmongo.domain.User;
import com.gustavodealmeida.workshopmongo.exceptions.ObjectNotFoundException;
import com.gustavodealmeida.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
