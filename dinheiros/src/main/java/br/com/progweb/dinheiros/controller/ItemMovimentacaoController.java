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
import br.com.progweb.dinheiros.model.ItemMovimentacao;
import br.com.progweb.dinheiros.repository.ItemMovimentacaoRepository;

@CrossOrigin
@Controller
@RequestMapping(value="/item")
public class ItemMovimentacaoController {

	@Autowired
	ItemMovimentacaoRepository repository;

	// cadastrar nova ItemMovimentacao
	@PostMapping
	public @ResponseBody ItemMovimentacao inserir(@RequestBody ItemMovimentacao ItemMovimentacao) {
		return repository.save(ItemMovimentacao);
	}

	@PutMapping(value = "/{id}")
	public @ResponseBody ItemMovimentacao alterar(@PathVariable("id") int id, @RequestBody ItemMovimentacao ItemMovimentacao) {
		return repository.save(ItemMovimentacao);
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody ItemMovimentacao findById(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@GetMapping
	public @ResponseBody List<ItemMovimentacao> listar() {
		return repository.findAll();
	}
}
