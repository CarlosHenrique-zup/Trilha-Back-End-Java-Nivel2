package br.com.zup.estrelas.carrinho.cliente.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	CarrinhoService carrinhoService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarQuadrinho(@Valid @RequestBody QuadrinhoDTO quadrinhoDTO) {
		return carrinhoService.adicionarQuadrinho(quadrinhoDTO);
	}

}
