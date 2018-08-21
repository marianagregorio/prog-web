package br.com.progweb.dinheiros.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.progweb.dinheiros.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
