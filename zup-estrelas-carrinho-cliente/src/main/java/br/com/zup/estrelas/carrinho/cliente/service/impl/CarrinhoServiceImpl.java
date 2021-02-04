package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.CarrinhoRepository;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	private static final String CARRINHO_CADASTRADO_COM_SUCESSO = "Carrinho cadastrado com sucesso!";
	private static final String CARRINHO_REMOVIDO_COM_SUCESSO = "Carrinho removido com sucesso!";
	private static final String CARRINHO_ALTERADO_COM_SUCESSO = "Carrinho alterado com sucesso!";
	private static final String CARRINHO_INEXISTENTE = "Carrinho inexistente!";

	@Autowired
	CarrinhoRepository carrinhoRepository;

	@Override
	public MensagemDTO adicionarQuadrinho(QuadrinhoDTO quadrinhoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarrinhoEntity> listarCarrinho() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MensagemDTO alterarQuadrinho(QuadrinhoDTO quadrinhoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MensagemDTO removerCarrinho(Long idCarrinho) {
		// TODO Auto-generated method stub
		return null;
	}

}
