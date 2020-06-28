package br.com.zerosystems.workshopmongo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.zerosystems.workshopmongo.domain.Post;

//usando spring data

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	public List<Post> findByTitleContaining(String text);
}
