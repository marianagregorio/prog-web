package br.com.progweb.dinheiros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.progweb.dinheiros.type.TipoConta;

@Entity
@Table(name="conta")
public class Conta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idConta", nullable=false)
	private int id;

	@NotNull
	@Column(name="tipo")
	private TipoConta tipo;

	@NotNull
	@Column(name="descricao", length=120, nullable=false)
	private String descricao;
	
	@Column(name="descResumida", length=20)
	private String descricaoResumida;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idUsuario", referencedColumnName="idUsuario")
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setId(int id) {
		this.id = id;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoResumida() {
		return descricaoResumida;
	}

	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimiteUsuario() {
		return limiteUsuario;
	}

	public void setLimiteUsuario(double limiteUsuario) {
		this.limiteUsuario = limiteUsuario;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Column(name="saldo", precision=2)
	private double saldo;

	@Column(name="limiteUsuario", precision=2)
	private double limiteUsuario;

	@Column(name="limite", precision=2)
	private double limite;
	
}
