package br.com.zerosystems.workshopmongo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zerosystems.workshopmongo.Repository.UserRepository;
import br.com.zerosystems.workshopmongo.Services.Exception.ObjectNotFoundException;
import br.com.zerosystems.workshopmongo.domain.User;
import br.com.zerosystems.workshopmongo.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
			
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);	
	}
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getId()).get();
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(),obj.getName(), obj.getEmail());
	}
}
