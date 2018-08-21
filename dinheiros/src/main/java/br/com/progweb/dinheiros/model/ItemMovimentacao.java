package br.com.progweb.dinheiros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_movimentacao")
public class ItemMovimentacao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idItem")
	private int id;
	
	@Column(name="descricao", nullable=false, length=120)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="idMov", referencedColumnName="idMov", nullable=false)
	private Movimentacao movimentacao;

	@Column(name="valor", nullable=false)
	private double valor;

	@Column(name="qtde", nullable=true)
	private int qtde;
	
	
}
