package com.invillia.acme.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.classe.Loja;
import com.invillia.acme.classe.Pagamento;
import com.invillia.acme.classe.Pedido;
import com.invillia.acme.repository.PagamentoRepository;
import com.invillia.acme.repository.PedidoRepository;

@RestController
@RequestMapping(value="/pagamento")
public class PagamentoController {

	@Autowired
	PagamentoRepository pagamentoRepository;

	
	/* Salvar pedido com Itens */
	@PostMapping("/criarPagamento")
	public Pagamento criarPedido(@Valid @RequestBody Pagamento pag) {
		return pagamentoRepository.save(pag);
	}

}
