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

import br.com.zup.estrelas.carrinho.cliente.dto.ClienteDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.ClienteEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarCliente(@Valid @RequestBody ClienteDTO clienteDTO) throws GenericException {
		return clienteService.adicionarCliente(clienteDTO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ClienteEntity> listarCliente() throws GenericException {
		return clienteService.listarClientes();
	}

	@PutMapping(path = "/{idCliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarCliente(@PathVariable Long idCliente, @Valid @RequestBody ClienteDTO clienteDTO)
			throws GenericException {
		return clienteService.alterarCliente(idCliente, clienteDTO);
	}

	@DeleteMapping(path = "/{idCliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerCliente(@PathVariable Long idCliente) throws GenericException {
		return clienteService.removerCliente(idCliente);
	}
}
