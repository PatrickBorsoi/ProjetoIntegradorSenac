package br.com.senac.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoriaDado implements Serializable{
	
	private static final long serialVersionUID = -6579966539493363449L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoria_dado_id;
	
	@OneToMany(mappedBy = "categoriadado")
	private List<DadoTipo> dadotipo;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String categoria_dado_descricao;
	
	public Integer getCategoria_dado_id() {
		return categoria_dado_id;
	}

	public void setCategoria_dado_id(Integer categoria_dado_id) {
		this.categoria_dado_id = categoria_dado_id;
	}

	public String getCategoria_dado_descricao() {
		return categoria_dado_descricao;
	}

	public void setCategoria_dado_descricao(String categoria_dado_descricao) {
		this.categoria_dado_descricao = categoria_dado_descricao;
	}

	public String getCategoria_dado_status() {
		return categoria_dado_status;
	}

	public void setCategoria_dado_status(String categoria_dado_status) {
		this.categoria_dado_status = categoria_dado_status;
	}

	private String categoria_dado_status;

}
