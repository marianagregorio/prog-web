package br.com.progweb.dinheiros.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.progweb.dinheiros.dto.LoginDTO;
import br.com.progweb.dinheiros.model.Usuario;
import br.com.progweb.dinheiros.repository.UsuarioRepository;
import br.com.progweb.dinheiros.type.Lingua;

@CrossOrigin
@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
	// cadastrar novo usuário
	@PostMapping(value = "/usuario")
	public @ResponseBody Usuario inserir(@RequestBody Usuario usuario) {
		usuario.setLingua(Lingua.valueOf("PT_BR"));
		usuario.setUltimaModificacaoSenha(new Date());
		return repository.save(usuario);
	}
	
	// login
	@PostMapping("/login")
	public @ResponseBody Optional<Usuario> autenticar(@RequestBody LoginDTO user) throws Exception{
		Usuario usuario = new Usuario();
		usuario.setSenha(user.getPassword());
		usuario.setUser(user.getUsername());
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnorePaths("idUsuario");
		if (repository.findOne(Example.of(usuario, matcher)).isPresent()) {
			System.out.println(repository.findOne(Example.of(usuario, matcher)));
			return repository.findOne(Example.of(usuario, matcher));
		};
		//TODO: exception usuário inválido
		throw new Exception();
	}
	
	@DeleteMapping("/usuario/{id}")
	public @ResponseBody Object excluir(@PathVariable("id") int id) {
		try {
			repository.delete(repository.findById(id).get());
			return new HashMap<>().put("mensagem", "Excluído!");
		} catch (IllegalArgumentException e) {
			return new HashMap<>().put("erro", e.getMessage());
		}
	}
	

}
