package br.com.zup.estrelas.carrinho.cliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.StatusPedidoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.StatusPedidoEntity;

@Service
public interface StatusPedidoService {

	public MensagemDTO adicionaStatusPedido(StatusPedidoDTO statusPedidoDTO);

	public List<StatusPedidoEntity> listarStatusPedido();

	public MensagemDTO removerStatusPedido(Long idStatusPedido);

}
