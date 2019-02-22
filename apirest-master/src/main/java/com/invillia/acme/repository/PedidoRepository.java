package com.invillia.acme.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.classe.ItemPedido;
import com.invillia.acme.classe.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	Pedido findAllById(Long p);
	
	
}
