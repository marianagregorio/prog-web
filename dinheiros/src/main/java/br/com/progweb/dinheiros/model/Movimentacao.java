package br.com.progweb.dinheiros.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMov")
	private int id;
	
	@Column(name="descricao", nullable=false, length=120)
	private String descricao;
	
	@Column(name="data", nullable=false)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="idConta", referencedColumnName="idConta", nullable=false)
	private Conta conta;
	
	@ManyToOne
	@JoinColumn(name="idEstabelecimento", referencedColumnName="idEstabelecimento")
	private Estabelecimento estabelecimento;
	
	@Column(name="valor", nullable=false)
	private double valor;
	
	
}
