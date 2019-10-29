/*
 * package br.com.senac.domain;
 * 
 * import java.io.Serializable; import java.util.Date;
 * 
 * import javax.persistence.Column; import javax.persistence.Embeddable; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne;
 * 
 * @Embeddable public class Cliente_possivel_produto implements Serializable {
 * 
 * private static final long serialVersionUID = -1039292140678161546L;
 * 
 * 
 * @Column(name = "cliente_possivel_produto_status") private String status;
 * 
 * @Column(name = "cliente_possivel_produto_data") private Date data;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "cliente_id") private Cliente cliente;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "produto_id") private Produto produto;
 * 
 * public String getStatus() { return status; }
 * 
 * public void setStatus(String status) { this.status = status; }
 * 
 * public Date getData() { return data; }
 * 
 * public void setData(Date data) { this.data = data; }
 * 
 * public Cliente getCliente() { return cliente; }
 * 
 * public void setCliente(Cliente cliente) { this.cliente = cliente; }
 * 
 * public Produto getProduto() { return produto; }
 * 
 * public void setProduto(Produto produto) { this.produto = produto; }
 * 
 * 
 * 
 * }
 */