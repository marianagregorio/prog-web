package br.com.progweb.dinheiros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEstabelecimento")
	private int id;
	
	@Column(name="nome", length=80, nullable=false)
	private String nome;
}
