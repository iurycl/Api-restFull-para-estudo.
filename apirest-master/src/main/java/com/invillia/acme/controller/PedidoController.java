package com.invillia.acme.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.classe.Loja;
import com.invillia.acme.classe.Pedido;
import com.invillia.acme.repository.PedidoRepository;

@RestController
@RequestMapping(value="/pedido")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;

	
	/* Salvar pedido com Itens */
	@PostMapping("/criarPedido")
	public Pedido criarPedido(@Valid @RequestBody Pedido p) {
		return pedidoRepository.save(p);
	}
	
	/*pegar pedido pelo id*/
	@GetMapping("/listarPedido/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable(value="id") Long pId){
		Pedido pe = pedidoRepository.findAllById(pId);
		
		if(pe == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pe);
	}
	
	/* reembolso de pedido*/
	@PutMapping("/reembolsoPedido/{id}")
	public @Valid ResponseEntity<Pedido> reembolsoPedido(@RequestBody @Valid Pedido pedido) {
		if(pedido.getId() == null) {
			return ResponseEntity.notFound().build();
		}
		
		if(pedido.getReembolso().equals(false)) {
			Long diferencaDia = ChronoUnit.DAYS.between(LocalDate.now(), pedido.getDataConfirmacao());
			if(diferencaDia <= 10 && pedido.getPagamento().getStatus().equals("concluido")) {
				pedido.setReembolso(true);
				Pedido p =  pedidoRepository.save(pedido);
				return ResponseEntity.ok().body(p);
			}
			
		}
		
		return ResponseEntity.notFound().build();
		
	}

}
