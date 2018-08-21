package br.com.progweb.dinheiros.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.progweb.dinheiros.model.ItemMovimentacao;
import br.com.progweb.dinheiros.model.Movimentacao;

@Repository
public interface ItemMovimentacaoRepository extends JpaRepository<ItemMovimentacao, Integer> {

}
