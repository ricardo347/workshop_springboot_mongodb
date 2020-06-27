package br.com.zerosystems.workshopmongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.zerosystems.workshopmongo.domain.User;

//usando spring data

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
