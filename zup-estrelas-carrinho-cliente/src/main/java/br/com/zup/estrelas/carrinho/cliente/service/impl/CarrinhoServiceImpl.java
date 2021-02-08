package br.com.zup.estrelas.carrinho.cliente.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.CarrinhoRepository;
import br.com.zup.estrelas.carrinho.cliente.repository.QuadrinhoRepository;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	private static final String QUADRINHO_CADASTRADO_COM_SUCESSO = "Quadrinho cadastrado com sucesso!";
	private static final String QUADRINHO_REMOVIDO_COM_SUCESSO = "Quadrinho removido com sucesso!";
	private static final String QUADRINHO_INEXISTENTE = "Quadrinho inexistente!";
	private static final String QUADRINHO_JA_EXISTENTE = "Quadrinho já existente!";
	private static final String QUADRINHO_JA_CADASTRADO_NO_CARRINHO = "Quadrinho já cadastrado!";
	private static final String QUADRINHO_ALTERADO_COM_SUCESSO = "Quadrinho alterado com sucesso!";

	@Autowired
	CarrinhoRepository carrinhoRepository;

	@Autowired
	QuadrinhoRepository quadrinhoRepository;

	public MensagemDTO adicionarQuadrinho(QuadrinhoDTO quadrinhoDTO) {
		QuadrinhoEntity quadrinho = new QuadrinhoEntity();

		if (quadrinhoRepository.existsByNome(quadrinhoDTO.getNome())) {
			return new MensagemDTO(QUADRINHO_JA_EXISTENTE);
		}

		BeanUtils.copyProperties(quadrinhoDTO, quadrinho);

		quadrinhoRepository.save(quadrinho);

		return new MensagemDTO(QUADRINHO_CADASTRADO_COM_SUCESSO);
	}

}
