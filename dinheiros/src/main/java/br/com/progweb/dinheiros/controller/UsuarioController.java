package br.com.progweb.dinheiros.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.progweb.dinheiros.model.Usuario;
import br.com.progweb.dinheiros.repository.UsuarioRepository;
import br.com.progweb.dinheiros.type.Lingua;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
	@PostMapping(value = "/usuario")
	public @ResponseBody Usuario inserir(@RequestBody Usuario usuario) {
		usuario.setLingua(Lingua.valueOf("PT_BR"));
		usuario.setUltimaModificacaoSenha(new Date());
		return repository.save(usuario);
	}
	
	@GetMapping("/usuario")
	public @ResponseBody Optional<Usuario> autenticar(@Valid @RequestBody String user, @RequestParam String senha) throws Exception{
		Usuario usuario = new Usuario();
		usuario.setSenha(senha);
		usuario.setUser(user);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnorePaths("idUsuario");
		if (repository.findOne(Example.of(usuario, matcher)).isPresent()) {
			System.out.println(repository.findOne(Example.of(usuario, matcher)));
			return repository.findOne(Example.of(usuario, matcher));
		};
		//TODO: exception usuário inválido
		throw new Exception();
	}
	

}
