package com.invillia.acme.classe;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private String endereco;
	@NotNull
	private LocalDate dataConfirmacao;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean reembolso;
	
	Loja loja;
	
	@NotNull
	private String status;
	
	ItemPedido itemPedido;
	
	Pagamento pagamento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public LocalDate getDataConfirmacao() {
		return dataConfirmacao;
	}
	public void setDataConfirmacao(LocalDate dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ItemPedido getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public Boolean getReembolso() {
		return reembolso;
	}
	public void setReembolso(Boolean reembolso) {
		this.reembolso = reembolso;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	

	
}
