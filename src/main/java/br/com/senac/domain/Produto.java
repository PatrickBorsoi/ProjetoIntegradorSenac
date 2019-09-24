package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = -7903014160907113528L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String nome;
	private String descricao;
	private String status;
	
	@OneToOne(fetch = FetchType.EAGER)
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
