package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.StatusPedidoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.StatusPedidoEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.StatusPedidoRepository;
import br.com.zup.estrelas.carrinho.cliente.service.StatusPedidoService;

@Service
public class StatusPedidoServiceImpl implements StatusPedidoService {

	private static final String STATUS_PEDIDO_CADASTRADO_COM_SUCESSO = "Status Pedido cadastrado com sucesso!";
	private static final String STATUS_PEDIDO_REMOVIDO_COM_SUCESSO = "Status pedido removido com sucesso!";
	private static final String STATUS_PEDIDO_JA_EXISTENTE = "Status pedido existente!";
	private static final String STATUS_PEDIDO_INEXISTENTE = "Status pedido inexistente!";

	@Autowired
	StatusPedidoRepository statusPedidoRepository;

	public MensagemDTO adicionaStatusPedido(StatusPedidoDTO statusPedidoDTO) {
		StatusPedidoEntity statusPedido = new StatusPedidoEntity();

		if (statusPedidoRepository.existsByNome(statusPedidoDTO.getNome())) {
			return new MensagemDTO(STATUS_PEDIDO_JA_EXISTENTE);
		}

		BeanUtils.copyProperties(statusPedidoDTO, statusPedido);
		statusPedidoRepository.save(statusPedido);

		return new MensagemDTO(STATUS_PEDIDO_CADASTRADO_COM_SUCESSO);
	}

	public List<StatusPedidoEntity> listarStatusPedido() {
		return (List<StatusPedidoEntity>) statusPedidoRepository.findAll();
	}

	public MensagemDTO removerStatusPedido(Long idStatusPedido) {
		if (statusPedidoRepository.existsById(idStatusPedido)) {
			statusPedidoRepository.deleteById(idStatusPedido);
		}

		return new MensagemDTO(STATUS_PEDIDO_REMOVIDO_COM_SUCESSO);
	}

}
