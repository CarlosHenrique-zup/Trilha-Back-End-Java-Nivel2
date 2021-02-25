package br.com.zup.estrelas.carrinho.cliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.carrinho.cliente.dto.ClienteDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.ClienteEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final Logger log = LoggerFactory.getLogger(CarrinhoController.class);

	private static final String CLIENTE_CADASTRADO_COM_SUCESSO = "Cliente cadastrado com sucesso!";
	private static final String CLIENTE_ALTERADO_COM_SUCESSO = "Cliente alterado com sucesso!";
	private static final String CLIENTE_REMOVIDO_COM_SUCESSO = "Cliente removido com sucesso!";

	@Autowired
	ClienteService clienteService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarCliente(@Valid @RequestBody ClienteDTO clienteDTO) throws GenericException {
		log.info("Entrando no metodo adicionar cliente no Controller: " + clienteDTO);
		clienteService.adicionarCliente(clienteDTO);

		return new MensagemDTO(CLIENTE_CADASTRADO_COM_SUCESSO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ClienteEntity> listarCliente() throws GenericException {
		log.info("Entrando no metodo listar cliente no Controller: ");
		return clienteService.listarClientes();
	}

	@PutMapping(path = "/{idCliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarCliente(@PathVariable Long idCliente, @Valid @RequestBody ClienteDTO clienteDTO)
			throws GenericException {
		log.info("Entrando no metodo listar cliente no Controller: ");
		clienteService.alterarCliente(idCliente, clienteDTO);

		return new MensagemDTO(CLIENTE_ALTERADO_COM_SUCESSO);
	}

	@DeleteMapping(path = "/{idCliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasRole('ADMIN')")
	public MensagemDTO removerCliente(@PathVariable Long idCliente) throws GenericException {
		log.info("Entrando no metodo listar cliente no Controller: " + idCliente);
		clienteService.removerCliente(idCliente);

		return new MensagemDTO(CLIENTE_REMOVIDO_COM_SUCESSO);
	}
}
