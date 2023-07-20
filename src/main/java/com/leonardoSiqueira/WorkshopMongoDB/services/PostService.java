package com.leonardoSiqueira.WorkshopMongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardoSiqueira.WorkshopMongoDB.domain.Post;
import com.leonardoSiqueira.WorkshopMongoDB.repository.PostRepository;
import com.leonardoSiqueira.WorkshopMongoDB.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	

	public Post findById(String id) {
	    Optional<Post> user = repo.findById(id);
	    return user.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}	

	public List<Post> FindByTitle(String text){
		return repo.findByTitleContainingIgnoringCase(text);
	}
	
	
}
