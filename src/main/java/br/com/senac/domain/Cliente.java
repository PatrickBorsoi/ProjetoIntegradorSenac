package br.com.senac.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = -6579966539493363449L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cliente_id;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@OneToMany(mappedBy = "cliente")
	private List<ClienteDado> clientedado;
	
	private String cliente_cpf;
	
	public List<ClienteDado> getClientedado() {
		return clientedado;
	}

	public void setClientedado(List<ClienteDado> clientedado) {
		this.clientedado = clientedado;
	}

	private String cliente_nome;
	
	private String cliente_sobrenome;
	
	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getCliente_cpf() {
		return cliente_cpf;
	}

	public void setCliente_cpf(String cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}

	public String getCliente_nome() {
		return cliente_nome;
	}

	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}

	public String getCliente_sobrenome() {
		return cliente_sobrenome;
	}

	public void setCliente_sobrenome(String cliente_sobrenome) {
		this.cliente_sobrenome = cliente_sobrenome;
	}

	public String getCliente_email() {
		return cliente_email;
	}

	public void setCliente_email(String cliente_email) {
		this.cliente_email = cliente_email;
	}

	public String getCliente_status() {
		return cliente_status;
	}

	public void setCliente_status(String cliente_status) {
		this.cliente_status = cliente_status;
	}

	private String cliente_email;
	
	private String cliente_status;
}
