package br.com.zerosystems.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.zerosystems.workshopmongo.Repository.UserRepository;
import br.com.zerosystems.workshopmongo.domain.User;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {	
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Fulana da silva", "fulana@uol.com.br");
		User joao = new User(null, "Joao canabrava", "joao@uol.com.br");
		User pedro = new User(null, "Pedro Fonseca", "pedro@uol.com.br");
		
		userRepository.saveAll(Arrays.asList(maria, joao, pedro));		
		
	}

	
}
