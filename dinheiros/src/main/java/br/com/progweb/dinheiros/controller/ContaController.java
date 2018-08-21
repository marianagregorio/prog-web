package br.com.progweb.dinheiros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.progweb.dinheiros.config.WebSecurityConfig;
import br.com.progweb.dinheiros.model.Conta;
import br.com.progweb.dinheiros.repository.ContaRepository;

@CrossOrigin
@Controller
@RequestMapping(value="/conta")
public class ContaController {

	@Autowired
	ContaRepository repository;

	// cadastrar nova conta para o usuário padrão
	@PostMapping
	public @ResponseBody Conta inserir(@RequestBody Conta conta) {
		conta.setUsuario(WebSecurityConfig.getUsuario());
		return repository.save(conta);
	}// cadastrar nova conta para o usuário padrão

	@PutMapping(value = "/{id}")
	public @ResponseBody Conta alterar(@PathVariable("id") int id, @RequestBody Conta conta) {
		conta.setUsuario(WebSecurityConfig.getUsuario());
		conta.setId(id);
		return repository.save(conta);
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Conta findById(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@GetMapping
	public @ResponseBody List<Conta> listar() {
		return repository.findAll();
	}
}
