package com.invillia.acme.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.invillia.acme.classe.Loja;
import com.invillia.acme.classe.Pedido;
import com.invillia.acme.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	/*pegar loja pelo id*/
	public Pedido pegarPedido(long p) {
		Pedido pedido = pedidoRepository.findAllById(p);
		return pedido;
	}
	
	/*atualizar loja pelo id */
	public Pedido reembolsarPedido(Pedido pedido) {
		if(pedido.getReembolso().equals(false)) {
			Long diferencaDia = ChronoUnit.DAYS.between(LocalDate.now(), pedido.getDataConfirmacao());
			if(diferencaDia <= 10 && pedido.getPagamento().getStatus().equals("concluido")) {
				pedido.setReembolso(true);
				Pedido p =  pedidoRepository.save(pedido);
				return p;
			}
		}
		return null;	
	}
}
