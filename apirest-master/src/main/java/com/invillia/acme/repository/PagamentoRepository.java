package com.invillia.acme.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.classe.ItemPedido;
import com.invillia.acme.classe.Pagamento;
import com.invillia.acme.classe.Pedido;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

	Pagamento findAllById(Long pag);
	
	
}
