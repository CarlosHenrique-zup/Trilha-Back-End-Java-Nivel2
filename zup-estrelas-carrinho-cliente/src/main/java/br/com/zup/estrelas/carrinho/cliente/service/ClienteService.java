package br.com.zup.estrelas.carrinho.cliente.service;

import java.util.List;

import br.com.zup.estrelas.carrinho.cliente.dto.ClienteDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.ClienteEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;

public interface ClienteService {

	public MensagemDTO adicionarCliente(ClienteDTO clienteDTO);

	public List<ClienteEntity> listarClientes();

	public ClienteEntity consultarPorId(Long idCliente) throws GenericException;

	public MensagemDTO alterarCliente(Long idCliente, ClienteDTO clienteDTO);

	public MensagemDTO removerCliente(Long idCliente);
}
