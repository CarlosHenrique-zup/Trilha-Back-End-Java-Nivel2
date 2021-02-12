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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.StatusPedidoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.StatusPedidoEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.StatusPedidoService;

@RestController
@RequestMapping("/statusPedido")
public class StatusPedidoController {

	private final Logger log = LoggerFactory.getLogger(CarrinhoController.class);

	private static final String STATUS_PEDIDO_CADASTRADO_COM_SUCESSO = "Status Pedido cadastrado com sucesso!";
	private static final String STATUS_PEDIDO_ALTERADO_COM_SUCESSO = "Status Pedido alterado com sucesso!";
	private static final String STATUS_PEDIDO_REMOVIDO_COM_SUCESSO = "Status Pedidos removido com sucesso!";

	@Autowired
	StatusPedidoService statusPedidoService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarStatusPedido(@Valid @RequestBody StatusPedidoDTO statusPedidoDTO)
			throws GenericException {
		log.info("Entrando no metodo adicionar status pedido no Controller: " + statusPedidoDTO);
		statusPedidoService.adicionaStatusPedido(statusPedidoDTO);

		return new MensagemDTO(STATUS_PEDIDO_CADASTRADO_COM_SUCESSO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<StatusPedidoEntity> listarStatusPedido() throws GenericException {
		log.info("Entrando no metodo listar status pedido no Controller:");
		return statusPedidoService.listarStatusPedido();
	}

	@DeleteMapping(path = "/{idStatusPedido}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerStatusPedido(@PathVariable Long idStatusPedido) throws GenericException {
		log.info("Entrando no metodo alterar status pedido no Controller: " + idStatusPedido);
		statusPedidoService.removerStatusPedido(idStatusPedido);

		return new MensagemDTO(STATUS_PEDIDO_REMOVIDO_COM_SUCESSO);
	}

}
