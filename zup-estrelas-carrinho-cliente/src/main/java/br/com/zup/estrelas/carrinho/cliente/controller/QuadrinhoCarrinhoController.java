package br.com.zup.estrelas.carrinho.cliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger log = LoggerFactory.getLogger(CarrinhoController.class);

	private static final String QUADRINHO_CARRINHO_CADASTRADO_COM_SUCESSO = "Quadrinho carrinho cadastrado com sucesso!";
	private static final String QUADRINHO_CARRINHO_ALTERADO_COM_SUCESSO = "Quadrinho carrinho alterado com sucesso!";
	private static final String QUADRINHO_CARRINHO_REMOVIDO_COM_SUCESSO = "Quadrinho carrinho removido com sucesso!";

	@Autowired
	QuadrinhoCarrinhoService quadrinhoCarrinhoService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarCliente(@Valid @RequestBody QuadrinhoCarrinhoDTO quadrinhoCarrinhoDTO)
			throws GenericException {
		log.info("Entrando no metodo adicionar quadrinho carrinho no Controller: " + quadrinhoCarrinhoDTO);
		quadrinhoCarrinhoService.adicionarQuadrinhoCarrinho(quadrinhoCarrinhoDTO);

		return new MensagemDTO(QUADRINHO_CARRINHO_CADASTRADO_COM_SUCESSO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<QuadrinhoCarrinhoEntity> listarQuadrinhoCarrinho() throws GenericException {
		log.info("Entrando no metodo listar cliente no Controller: ");
		return quadrinhoCarrinhoService.listarQuadrinhoCarrinho();
	}

	@PutMapping(path = "/{idCliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarQuadrinhoCarrinho(@PathVariable Long idQuadrinhoCarrinho,
			@Valid @RequestBody QuadrinhoCarrinhoDTO quadrinhoCarrinhoDTO) throws GenericException {
		log.info("Entrando no metodo alterar quadrinho carrinho no Controller: ");
		quadrinhoCarrinhoService.alterarQuadrinhoCarrinho(idQuadrinhoCarrinho, quadrinhoCarrinhoDTO);

		return new MensagemDTO(QUADRINHO_CARRINHO_ALTERADO_COM_SUCESSO);
	}

	@DeleteMapping(path = "/{idCliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerQuadrinhoCarrinho(@PathVariable Long idQuadrinhoCarrinho) throws GenericException {
		log.info("Entrando no metodo remover quadrinho carrinho no Controller: ");
		quadrinhoCarrinhoService.removerQuadrinhoCarrinho(idQuadrinhoCarrinho);

		return new MensagemDTO(QUADRINHO_CARRINHO_REMOVIDO_COM_SUCESSO);
	}
}
