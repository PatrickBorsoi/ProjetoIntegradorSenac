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
public class ClienteDado implements Serializable{

	private static final long serialVersionUID = -6579966539493363449L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cliente_dado_id;
	
	private String cliente_dado_valor;
	
	private String cliente_dado_status;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Integer getCliente_dado_id() {
		return cliente_dado_id;
	}

	public void setCliente_dado_id(Integer cliente_dado_id) {
		this.cliente_dado_id = cliente_dado_id;
	}

	public String getCliente_dado_valor() {
		return cliente_dado_valor;
	}

	public void setCliente_dado_valor(String cliente_dado_valor) {
		this.cliente_dado_valor = cliente_dado_valor;
	}

	public String getCliente_dado_status() {
		return cliente_dado_status;
	}

	public void setCliente_dado_status(String cliente_dado_status) {
		this.cliente_dado_status = cliente_dado_status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DadoTipo getDadotipo() {
		return dadotipo;
	}

	public void setDadotipo(DadoTipo dadotipo) {
		this.dadotipo = dadotipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToOne
    @JoinColumn(name = "dado_tipo_id")
    private DadoTipo dadotipo;

}
