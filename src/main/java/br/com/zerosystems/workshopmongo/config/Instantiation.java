package br.com.zerosystems.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.zerosystems.workshopmongo.Repository.PostRepository;
import br.com.zerosystems.workshopmongo.Repository.UserRepository;
import br.com.zerosystems.workshopmongo.domain.Post;
import br.com.zerosystems.workshopmongo.domain.User;
import br.com.zerosystems.workshopmongo.dto.AuthorDTO;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {	
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Fulana da silva", "fulana@uol.com.br");
		User joao = new User(null, "Joao canabrava", "joao@uol.com.br");
		User pedro = new User(null, "Pedro Fonseca", "pedro@uol.com.br");
		
		userRepository.saveAll(Arrays.asList(maria, joao, pedro));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem", "Vou viajar para italia com minha mae",  new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem segunda", "Vou viajar para França", new AuthorDTO(maria));
				
				
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

	
}
