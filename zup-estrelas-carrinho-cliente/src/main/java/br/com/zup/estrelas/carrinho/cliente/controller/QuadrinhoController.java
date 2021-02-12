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
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.QuadrinhoService;

@RestController
@RequestMapping("/quadrinho")
public class QuadrinhoController {

	private final Logger log = LoggerFactory.getLogger(CarrinhoController.class);

	private static final String QUADRINHO_CADASTRADO_COM_SUCESSO = "Quadrinho cadastrado com sucesso!";
	private static final String QUADRINHO_ALTERADO_COM_SUCESSO = "Quadrinho alterado com sucesso!";
	private static final String QUADRINHO_REMOVIDO_COM_SUCESSO = "Quadrinho removido com sucesso!";

	@Autowired
	QuadrinhoService quadrinhoService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarQuadrinho(@Valid @RequestBody QuadrinhoDTO quadrinhoDTO) throws GenericException {
		log.info("Entrando no metodo adicionar quadrinho no Controller: " + quadrinhoDTO);
		quadrinhoService.adicionarQuadrinho(quadrinhoDTO);
		return new MensagemDTO(QUADRINHO_CADASTRADO_COM_SUCESSO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<QuadrinhoEntity> listarQuadrinho() throws GenericException {
		log.info("Entrando no metodo listar quadrinho no Controller: ");
		return quadrinhoService.listarQuadrinho();
	}

	@PutMapping(path = "/{idQuadrinho}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarQuadrinho(@PathVariable Long idQuadrinho, @Valid @RequestBody QuadrinhoDTO quadrinhoDTO)
			throws GenericException {
		log.info("Entrando no metodo alterar quadrinho no Controller: " + quadrinhoDTO);
		quadrinhoService.alterarQuadrinho(idQuadrinho, quadrinhoDTO);
		return new MensagemDTO(QUADRINHO_ALTERADO_COM_SUCESSO);
	}

	@DeleteMapping(path = "/{idQuadrinho}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerQuadrinho(@PathVariable Long idQuadrinho) throws GenericException {
		log.info("Entrando no metodo remover quadrinho no Controller: " + idQuadrinho);
		quadrinhoService.removerQuadrinho(idQuadrinho);
		return new MensagemDTO(QUADRINHO_REMOVIDO_COM_SUCESSO);
	}
}
