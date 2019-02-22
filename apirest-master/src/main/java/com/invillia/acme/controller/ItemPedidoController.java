package com.invillia.acme.controller;

import java.util.List;

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

import com.invillia.acme.classe.ItemPedido;
import com.invillia.acme.classe.Loja;
import com.invillia.acme.repository.ItemPedidoRepository;
import com.invillia.acme.repository.LojaRepository;

@RestController
@RequestMapping(value="/itemPedido")
public class ItemPedidoController {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	/* Pegar todas os itens*/
	@GetMapping("/listaItemPedido")
	public List<ItemPedido> getAllItemPedido(){
		return itemPedidoRepository.findAll();
	}
	
	/* Salvar item */
	@PostMapping("/criarItemPedido")
	public ItemPedido criarItemPedido(@Valid @RequestBody ItemPedido ip) {
		return itemPedidoRepository.save(ip);
	}
	

}
