package br.com.progweb.dinheiros.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.progweb.dinheiros.model.Usuario;
import br.com.progweb.dinheiros.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
	@PostMapping("/usuario")
	public Usuario inserir(@Valid @RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@GetMapping("/usuario")
	public Optional<Usuario> autenticar(@Valid @RequestBody Usuario usuario) throws Exception{
		ExampleMatcher matcher = ExampleMatcher.matching();//.withMatcher("user");
		if (repository.findOne(Example.of(usuario, matcher)) != null) { //Example
			return repository.findOne(null);
		};
		//TODO: exception usuário inválido
		throw new Exception();
	}
	

}
