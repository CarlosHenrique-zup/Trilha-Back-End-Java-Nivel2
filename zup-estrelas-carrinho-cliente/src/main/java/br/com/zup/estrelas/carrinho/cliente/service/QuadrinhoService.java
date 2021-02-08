package br.com.zup.estrelas.carrinho.cliente.service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;

public interface QuadrinhoService {

	public MensagemDTO adicionarQuadrinho(QuadrinhoDTO quadrinhoDTO);

	public MensagemDTO alterarQuadrinho(Long idQuadrinho, QuadrinhoDTO quadrinhoDTO);

	public MensagemDTO removerQuadrinho(Long idQuadrinho);

}
