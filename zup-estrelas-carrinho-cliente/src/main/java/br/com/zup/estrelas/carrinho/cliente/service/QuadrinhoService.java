package br.com.zup.estrelas.carrinho.cliente.service;

import java.util.List;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoEntity;

public interface QuadrinhoService {

	public MensagemDTO adicionarQuadrinho(QuadrinhoDTO quadrinhoDTO);

	public List<QuadrinhoEntity> listarQuadrinho();

	public MensagemDTO alterarQuadrinho(Long idQuadrinho, QuadrinhoDTO quadrinhoDTO);

	public MensagemDTO removerQuadrinho(Long idQuadrinho);

}
