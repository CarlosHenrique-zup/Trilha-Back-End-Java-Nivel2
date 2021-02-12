package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.controller.CarrinhoController;
import br.com.zup.estrelas.carrinho.cliente.dto.CarrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoCarrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.entity.ClienteEntity;
import br.com.zup.estrelas.carrinho.cliente.entity.StatusPedidoEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.CarrinhoRepository;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	private final Logger log = LoggerFactory.getLogger(CarrinhoController.class);

	private static final String CARRINHO_CADASTRADO_COM_SUCESSO = "Carrinho adicionado com sucesso!";
	private static final String CARRINHO_JÁ_EXISTENTE = "Carrinho Existente";
	private static final String CARRINHO_REMOVIDO_COM_SUCESSO = "Carrinho removido com sucesso!";
	private static final String CARRINHO_INEXISTENTE = "Carrinho Inexistente";
	private static final String CARRINHO_ALTERADO_COM_SUCESSO = "Carrinho Alterado com sucesso!";

	@Autowired
	CarrinhoRepository carrinhoRepository;

	@Autowired
	QuadrinhoCarrinhoServiceImpl quadrinhoCarrinhoServiceImpl;

	public MensagemDTO adicionarCarrinho(CarrinhoDTO carrinhoDTO) {
		log.info("Entrando no metodo adicionar carrinho na classe Service: " + carrinhoDTO);
		CarrinhoEntity carrinho = new CarrinhoEntity();

		if (carrinhoRepository.existsByNome(carrinho.getNome())) {
			return new MensagemDTO(CARRINHO_JÁ_EXISTENTE);
		}

		BeanUtils.copyProperties(carrinhoDTO, carrinho);

		StatusPedidoEntity statusPedido = new StatusPedidoEntity();
		statusPedido.setIdStatusPedido(carrinhoDTO.getStatusPedido().getIdStatusPedido());
		carrinho.setStatusPedido(statusPedido);

		ClienteEntity cliente = new ClienteEntity();
		cliente.setIdCliente(carrinhoDTO.getCliente().getIdCliente());
		carrinho.setCliente(cliente);

		carrinhoRepository.save(carrinho);

		for (QuadrinhoCarrinhoDTO quadrinhoCarrinho : carrinhoDTO.getQuadrinhoCarrinho()) {
			quadrinhoCarrinho.setIdCarrinho(carrinho.getIdCarrinho());

			quadrinhoCarrinhoServiceImpl.adicionarQuadrinhoCarrinho(quadrinhoCarrinho);
		}

		return new MensagemDTO(CARRINHO_CADASTRADO_COM_SUCESSO);
	}

	public List<CarrinhoEntity> listarCarrinhos() {
		log.info("Entrando no metodo listar carrinho na classe Service: ");
		return (List<CarrinhoEntity>) carrinhoRepository.findAll();
	}

	public MensagemDTO alterarCarrinho(Long idCarrinho, CarrinhoDTO carrinhoDTO) {
		log.info("Entrando no metodo alterar carrinho na classe Service: " + carrinhoDTO);
		Optional<CarrinhoEntity> carrinhoConsultado = carrinhoRepository.findById(idCarrinho);

		if (carrinhoConsultado.isEmpty()) {
			return new MensagemDTO(CARRINHO_INEXISTENTE);
		}

		CarrinhoEntity carrinhoAlterado = carrinhoConsultado.get();

		BeanUtils.copyProperties(carrinhoDTO, carrinhoAlterado);
		return new MensagemDTO(CARRINHO_ALTERADO_COM_SUCESSO);
	}

	public MensagemDTO removerCarrinho(Long idCarrinho) {
		log.info("Entrando no metodo remover carrinho na classe Service: " + idCarrinho);
		if (carrinhoRepository.existsById(idCarrinho)) {
			carrinhoRepository.deleteById(idCarrinho);
		}

		return new MensagemDTO(CARRINHO_REMOVIDO_COM_SUCESSO);
	}

}
