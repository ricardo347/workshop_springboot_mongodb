package br.com.zerosystems.workshopmongo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zerosystems.workshopmongo.Repository.PostRepository;
import br.com.zerosystems.workshopmongo.Services.Exception.ObjectNotFoundException;
import br.com.zerosystems.workshopmongo.domain.Post;
import br.com.zerosystems.workshopmongo.domain.User;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
			
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContaining(text);
	}
	
}
