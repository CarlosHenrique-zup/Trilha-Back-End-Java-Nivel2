package br.com.zup.estrelas.carrinho.cliente.service;

import java.util.List;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;

public interface CarrinhoService {

	public MensagemDTO adicionarQuadrinho(QuadrinhoDTO quadrinhoDTO);

	public List<CarrinhoEntity> listarCarrinho();

	public MensagemDTO alterarQuadrinho(QuadrinhoDTO quadrinhoDTO);

	public MensagemDTO removerCarrinho(Long idCarrinho);

}
