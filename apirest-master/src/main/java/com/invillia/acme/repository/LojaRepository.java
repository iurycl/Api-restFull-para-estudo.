package com.invillia.acme.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.classe.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long> {

	Loja findAllById(Long ljid);
	
	
}
