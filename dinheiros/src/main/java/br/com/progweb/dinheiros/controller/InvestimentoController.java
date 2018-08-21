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

import br.com.progweb.dinheiros.model.Investimento;
import br.com.progweb.dinheiros.repository.InvestimentoRepository;

@CrossOrigin
@Controller
@RequestMapping(value="/investimento")
public class InvestimentoController {

	@Autowired
	InvestimentoRepository repository;

	// cadastrar nova Investimento
	@PostMapping
	public @ResponseBody Investimento inserir(@RequestBody Investimento Investimento) {
		return repository.save(Investimento);
	}

	@PutMapping(value = "/{id}")
	public @ResponseBody Investimento alterar(@PathVariable("id") int id, @RequestBody Investimento Investimento) {
		return repository.save(Investimento);
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Investimento findById(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@GetMapping
	public @ResponseBody List<Investimento> listar() {
		return repository.findAll();
	}
}
