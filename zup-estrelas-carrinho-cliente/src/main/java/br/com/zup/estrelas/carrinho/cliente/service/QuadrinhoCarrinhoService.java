package br.com.zup.estrelas.carrinho.cliente.service;

import java.util.List;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoCarrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoCarrinhoEntity;

public interface QuadrinhoCarrinhoService {

	public MensagemDTO adicionarQuadrinhoCarrinho(QuadrinhoCarrinhoDTO carrinhoQuadrinhoDTO);

	public List<QuadrinhoCarrinhoEntity> listarQuadrinhoCarrinho();

	public MensagemDTO alterarQuadrinhoCarrinho(Long idQuadrinhoCarrinho, QuadrinhoCarrinhoDTO carrinhoQuadrinhoDTO);

	public MensagemDTO removerQuadrinhoCarrinho(Long idQuadrinhoCarrinho);
}
