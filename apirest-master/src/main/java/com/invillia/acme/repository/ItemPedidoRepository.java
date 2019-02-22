package com.invillia.acme.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.classe.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

	ItemPedido findAllById(Long ipid);
	
	
}
