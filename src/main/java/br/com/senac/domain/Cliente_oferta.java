package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cliente_oferta implements Serializable{

	private static final long serialVersionUID = 8592671329957601159L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_oferta_id")
	private Integer id;
	
	@Column(name = "cliente_oferta_preco")
	private Double preco;
	
	@Column(name = "cliente_oferta_descricao")
	private String descricao;
	
	@Column(name = "cliente_oferta_status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "funil_etapa_id")
	private Funil_etapa funilEtapa;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	/*@ManyToOne
	@JoinColumn(name = "oferta_id")
	private Oferta oferta;*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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

	public Funil_etapa getFunilEtapa() {
		return funilEtapa;
	}

	public void setFunilEtapa(Funil_etapa funilEtapa) {
		this.funilEtapa = funilEtapa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/*public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	
	*/
	
	
	

}
