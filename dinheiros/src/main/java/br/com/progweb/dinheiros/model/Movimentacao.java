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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@ManyToOne
	@JoinColumn(name="idConta", referencedColumnName="idConta", nullable=false)
	private Conta conta;
	
	@ManyToOne
	@JoinColumn(name="idEstabelecimento", referencedColumnName="idEstabelecimento")
	private Estabelecimento estabelecimento;
	
	@Column(name="valor", nullable=false)
	private double valor;
	
	
}
