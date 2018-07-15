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
	
	@PostMapping(value = "/usuario",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
    produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Usuario inserir(@Valid @RequestParam String user,
			@Valid @RequestParam String senha, @Valid @RequestParam String email,
			@Valid @RequestParam String nome
			//, @Valid @RequestParam String lingua
			) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setLingua(Lingua.valueOf("PT_BR"));
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setUltimaModificacaoSenha(new Date());
		usuario.setUser(user);
		return repository.save(usuario);
	}
	
	@GetMapping("/usuario")
	public Optional<Usuario> autenticar(@Valid @RequestParam Usuario usuario) throws Exception{
		ExampleMatcher matcher = ExampleMatcher.matching();//.withMatcher("user");
		if (repository.findOne(Example.of(usuario, matcher)) != null) { //Example
			return repository.findOne(null);
		};
		//TODO: exception usuário inválido
		throw new Exception();
	}
	
	@GetMapping("/usuario/novo")
	public String novoUsuario() {
		return "cadUser";
	}
	

}
