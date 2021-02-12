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

import br.com.zup.estrelas.carrinho.cliente.dto.CarrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	private final Logger log = LoggerFactory.getLogger(CarrinhoController.class);

	private static final String CARRINHO_CADASTRADO_COM_SUCESSO = "Carrinho cadastrado com sucesso!";
	private static final String CARRINHO_ALTERADO_COM_SUCESSO = "Carrinho alterado com sucesso!";
	private static final String CARRINHO_REMOVIDO_COM_SUCESSO = "Carrinho removido com sucesso!";

	@Autowired
	CarrinhoService carrinhoService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarCarrinho(@Valid @RequestBody CarrinhoDTO carrinhoDTO) throws GenericException {
		log.info("Entrando no metodo adicionar carrinho no Controller: " + carrinhoDTO);
		carrinhoService.adicionarCarrinho(carrinhoDTO);

		return new MensagemDTO(CARRINHO_CADASTRADO_COM_SUCESSO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CarrinhoEntity> listarCarrinho() throws GenericException {
		log.info("Entrando no metodo listar carrinho no Controller: ");
		return carrinhoService.listarCarrinhos();
	}

	@PutMapping(path = "/{idCarrinho}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarCarrinho(@PathVariable Long idCarrinho, @Valid @RequestBody CarrinhoDTO carrinhoDTO)
			throws GenericException {
		log.info("Entrando no metodo alterar carrinho no Controller: " + carrinhoDTO);
		carrinhoService.alterarCarrinho(idCarrinho, carrinhoDTO);

		return new MensagemDTO(CARRINHO_ALTERADO_COM_SUCESSO);
	}

	@DeleteMapping(path = "/{idCarrinho}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerCarrinho(@PathVariable Long idCarrinho) throws GenericException {
		log.info("Entrando no metodo remover carrinho no Controller: " + idCarrinho);
		carrinhoService.removerCarrinho(idCarrinho);

		return new MensagemDTO(CARRINHO_REMOVIDO_COM_SUCESSO);
	}
}
