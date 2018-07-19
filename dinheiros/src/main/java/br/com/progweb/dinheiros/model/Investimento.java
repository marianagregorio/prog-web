package br.com.progweb.dinheiros.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="investimento")
public class Investimento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idInv")
	private int id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="idMov", referencedColumnName="idMov", nullable=false)
	private Movimentacao movimentacao;
	
	@NotNull
	@Column(name="jurosAA", nullable=false, precision=2)
	private double jurosAA;
	
	@NotNull
	@Column(name="dataVcto", nullable=false)
	private Date vencimento;
}
