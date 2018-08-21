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
import br.com.progweb.dinheiros.model.Estabelecimento;
import br.com.progweb.dinheiros.repository.EstabelecimentoRepository;

@CrossOrigin
@Controller
@RequestMapping(value="/estabelecimento")
public class EstabelecimentoController {

	@Autowired
	EstabelecimentoRepository repository;

	// cadastrar nova Estabelecimento
	@PostMapping
	public @ResponseBody Estabelecimento inserir(@RequestBody Estabelecimento Estabelecimento) {
		return repository.save(Estabelecimento);
	}

	@PutMapping(value = "/{id}")
	public @ResponseBody Estabelecimento alterar(@PathVariable("id") int id, @RequestBody Estabelecimento Estabelecimento) {
		return repository.save(Estabelecimento);
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Estabelecimento findById(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@GetMapping
	public @ResponseBody List<Estabelecimento> listar() {
		return repository.findAll();
	}
}
