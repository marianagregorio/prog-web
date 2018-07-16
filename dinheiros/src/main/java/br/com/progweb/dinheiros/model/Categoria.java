package br.com.progweb.dinheiros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCat")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idCatMae", referencedColumnName="idCat")
	private Categoria categoria;
	
	@NotBlank
	@Column(name="descricao", length=80)
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
