package com.gustavodealmeida.workshopmongo.services;

import com.gustavodealmeida.workshopmongo.domain.Post;
import com.gustavodealmeida.workshopmongo.exceptions.ObjectNotFoundException;
import com.gustavodealmeida.workshopmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id){
        Optional<Post> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
