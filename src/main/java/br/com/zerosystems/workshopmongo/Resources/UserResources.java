package br.com.zerosystems.workshopmongo.Resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zerosystems.workshopmongo.Services.UserService;
import br.com.zerosystems.workshopmongo.domain.User;
import br.com.zerosystems.workshopmongo.dto.UserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {

		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {

		User obj = service.fromDTO(objDTO);
		obj = service.insert(obj);

		// retorna o codigo 201 para o sucesso
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	//response 204 para deleções
	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id) {

		User obj = service.fromDTO(objDTO);
		obj.setId(id);		
		obj = service.update(obj);
	
		return ResponseEntity.noContent().build();
	}

}
