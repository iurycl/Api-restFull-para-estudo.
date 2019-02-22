package com.invillia.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.invillia.acme.classe.Loja;
import com.invillia.acme.repository.LojaRepository;

@Service
public class LojaService {

	@Autowired
	private LojaRepository lojaRepository;
	
	/*pegar loja pelo id*/
	public Loja pegarLoja(long lj) {
		Loja l = lojaRepository.findAllById(lj);
		return l;
	}
	
	/*atualizar loja pelo id */
	public Loja attLoja(Loja loja) {
		Loja l = lojaRepository.save(loja);
		return l;
	}
}
