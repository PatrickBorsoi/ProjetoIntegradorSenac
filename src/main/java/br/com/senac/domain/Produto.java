package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = -7903014160907113528L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private Integer Id;
	
	@Column(name = "produto_nome")
	private String nome;
	
	@Column(name = "produto_descricao")
	private String descricao;
	
	@Column(name = "produto_status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "nivel_instrucao_id")
	
	private NivelInstrucao nivelInstrucao;
	
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public NivelInstrucao getNivelInstrucao() {
		return nivelInstrucao;
	}
	public void setNivelInstrucao(NivelInstrucao nivelInstrucao) {
		this.nivelInstrucao = nivelInstrucao;
	}
	
}
