package br.com.zerosystems.workshopmongo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zerosystems.workshopmongo.Repository.UserRepository;
import br.com.zerosystems.workshopmongo.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
