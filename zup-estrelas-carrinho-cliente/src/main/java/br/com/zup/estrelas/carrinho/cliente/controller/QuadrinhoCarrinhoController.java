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

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoCarrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoCarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.QuadrinhoCarrinhoService;

@RestController
@RequestMapping("/quadrinhoCarrinho")
public class QuadrinhoCarrinhoController {

	@Autowired
	QuadrinhoCarrinhoService quadrinhoCarrinhoService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarCliente(@Valid @RequestBody QuadrinhoCarrinhoDTO quadrinhoCarrinhoDTO)
			throws GenericException {
		return quadrinhoCarrinhoService.adicionarQuadrinhoCarrinho(quadrinhoCarrinhoDTO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<QuadrinhoCarrinhoEntity> listarCliente() throws GenericException {
		return quadrinhoCarrinhoService.listarQuadrinhoCarrinho();
	}

	@PutMapping(path = "/{idCliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarQuadrinhoCarrinho(@PathVariable Long idQuadrinhoCarrinho,
			@Valid @RequestBody QuadrinhoCarrinhoDTO quadrinhoCarrinhoDTO) throws GenericException {
		return quadrinhoCarrinhoService.alterarQuadrinhoCarrinho(idQuadrinhoCarrinho, quadrinhoCarrinhoDTO);
	}

	@DeleteMapping(path = "/{idCliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerQuadrinhoCarrinho(@PathVariable Long idQuadrinhoCarrinho) throws GenericException {
		return quadrinhoCarrinhoService.removerQuadrinhoCarrinho(idQuadrinhoCarrinho);
	}
}
