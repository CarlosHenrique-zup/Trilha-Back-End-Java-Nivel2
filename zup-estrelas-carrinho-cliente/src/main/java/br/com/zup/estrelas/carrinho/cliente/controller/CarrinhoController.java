package br.com.zup.estrelas.carrinho.cliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.carrinho.cliente.dto.CarrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	CarrinhoService carrinhoService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarCarrinho(@Valid @RequestBody CarrinhoDTO carrinhoDTO) throws GenericException {
		return carrinhoService.adicionarCarrinho(carrinhoDTO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CarrinhoEntity> listarCarrinho() throws GenericException {
		return carrinhoService.listarCarrinhos();
	}

	@PutMapping(path = "/{idCarrinho}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarCarrinho(@PathVariable Long idCarrinho, @Valid @RequestBody CarrinhoDTO carrinhoDTO)
			throws GenericException {
		return carrinhoService.alterarCarrinho(idCarrinho, carrinhoDTO);
	}

	@DeleteMapping(path = "/{idCarrinho}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerCarrinho(@PathVariable Long idCarrinho) throws GenericException {
		return carrinhoService.removerCarrinho(idCarrinho);
	}
}
