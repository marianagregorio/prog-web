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
import br.com.progweb.dinheiros.model.Categoria;
import br.com.progweb.dinheiros.repository.CategoriaRepository;

@CrossOrigin
@Controller
@RequestMapping(value="/categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository repository;

	// cadastrar nova Categoria para o usuário padrão
	@PostMapping
	public @ResponseBody Categoria inserir(@RequestBody Categoria Categoria) {
		return repository.save(Categoria);
	}// cadastrar nova Categoria para o usuário padrão

	@PutMapping(value = "/{id}")
	public @ResponseBody Categoria alterar(@PathVariable("id") int id, @RequestBody Categoria Categoria) {
		Categoria.setId(id);
		return repository.save(Categoria);
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Categoria findById(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@GetMapping
	public @ResponseBody List<Categoria> listar() {
		return repository.findAll();
	}
}
