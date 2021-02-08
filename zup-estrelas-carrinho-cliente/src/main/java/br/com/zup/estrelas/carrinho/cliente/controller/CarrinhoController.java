package br.com.zup.estrelas.carrinho.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	CarrinhoService carrinhoService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CarrinhoEntity> listarCarrinho() throws GenericException {
		return carrinhoService.listarCarrinhos();
	}
}
