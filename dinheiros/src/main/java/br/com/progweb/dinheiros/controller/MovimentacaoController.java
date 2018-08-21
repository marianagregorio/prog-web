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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.progweb.dinheiros.model.Conta;
import br.com.progweb.dinheiros.model.Movimentacao;
import br.com.progweb.dinheiros.repository.MovimentacaoRepository;

@CrossOrigin
@Controller
@RequestMapping(value="/movimentacao")
public class MovimentacaoController {

	@Autowired
	MovimentacaoRepository repository;

	// cadastrar nova Movimentacao
	@PostMapping
	public @ResponseBody Movimentacao inserir(@RequestParam int idConta, @RequestBody Movimentacao movimentacao) {
		Conta conta = new Conta();
		movimentacao.setConta(conta);
		conta.setId(idConta);
		return repository.save(movimentacao);
	}

	@PutMapping(value = "/{id}")
	public @ResponseBody Movimentacao alterar(@PathVariable("id") int id, @RequestBody Movimentacao movimentacao) {
		return repository.save(movimentacao);
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

	@GetMapping(value = "/{id}")
	public @ResponseBody Movimentacao findById(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@GetMapping
	public @ResponseBody List<Movimentacao> listar() {
		return repository.findAll();
	}
}
