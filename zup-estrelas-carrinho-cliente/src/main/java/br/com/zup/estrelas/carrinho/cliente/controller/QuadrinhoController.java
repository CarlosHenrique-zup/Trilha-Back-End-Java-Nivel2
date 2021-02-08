package br.com.zup.estrelas.carrinho.cliente.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.QuadrinhoService;

@RestController
@RequestMapping("/quadrinho")
public class QuadrinhoController {

	@Autowired
	QuadrinhoService quadrinhoService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarQuadrinho(@Valid @RequestBody QuadrinhoDTO quadrinhoDTO) throws GenericException {
		return quadrinhoService.adicionarQuadrinho(quadrinhoDTO);
	}

	@PutMapping(path = "/{idQuadrinho}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarQuadrinho(@PathVariable Long idQuadrinho, @Valid @RequestBody QuadrinhoDTO quadrinhoDTO)
			throws GenericException {
		return quadrinhoService.alterarQuadrinho(idQuadrinho, quadrinhoDTO);
	}

	@DeleteMapping(path = "/{idQuadrinho}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerQuadrinho(@PathVariable Long idQuadrinho) throws GenericException {
		return quadrinhoService.removerQuadrinho(idQuadrinho);
	}
}
