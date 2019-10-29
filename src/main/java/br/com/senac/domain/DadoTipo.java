package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DadoTipo implements Serializable{
	
	private static final long serialVersionUID = -6579966539493363449L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer dado_tipo_id;
	
	private String dado_tipo_descricao;
	
	private String dado_tipo_status;
	
	private String dado_tipo_obrigatorio;
	
	private String dado_tipo_padrao;
	
	private String dado_tipo_mascara;
	
	@OneToOne
	private ClienteDado clientedado;
	
	public ClienteDado getClientedado() {
		return clientedado;
	}

	public void setClientedado(ClienteDado clientedado) {
		this.clientedado = clientedado;
	}

	@ManyToOne
	@JoinColumn(name="categoria_dado_id")
	private CategoriaDado categoriadado;
	
	public Integer getDado_tipo_id() {
		return dado_tipo_id;
	}

	public void setDado_tipo_id(Integer dado_tipo_id) {
		this.dado_tipo_id = dado_tipo_id;
	}

	public String getDado_tipo_descricao() {
		return dado_tipo_descricao;
	}

	public void setDado_tipo_descricao(String dado_tipo_descricao) {
		this.dado_tipo_descricao = dado_tipo_descricao;
	}

	public String getDado_tipo_status() {
		return dado_tipo_status;
	}

	public void setDado_tipo_status(String dado_tipo_status) {
		this.dado_tipo_status = dado_tipo_status;
	}

	public String getDado_tipo_obrigatorio() {
		return dado_tipo_obrigatorio;
	}

	public void setDado_tipo_obrigatorio(String dado_tipo_obrigatorio) {
		this.dado_tipo_obrigatorio = dado_tipo_obrigatorio;
	}

	public String getDado_tipo_padrao() {
		return dado_tipo_padrao;
	}

	public void setDado_tipo_padrao(String dado_tipo_padrao) {
		this.dado_tipo_padrao = dado_tipo_padrao;
	}

	public String getDado_tipo_mascara() {
		return dado_tipo_mascara;
	}

	public void setDado_tipo_mascara(String dado_tipo_mascara) {
		this.dado_tipo_mascara = dado_tipo_mascara;
	}

	public CategoriaDado getCategoriadado() {
		return categoriadado;
	}

	public void setCategoriadado(CategoriaDado categoriadado) {
		this.categoriadado = categoriadado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
