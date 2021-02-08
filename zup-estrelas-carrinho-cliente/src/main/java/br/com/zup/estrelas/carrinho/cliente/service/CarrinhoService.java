package br.com.zup.estrelas.carrinho.cliente.service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;

public interface CarrinhoService {

	public MensagemDTO adicionarQuadrinho(QuadrinhoDTO quadrinhoDTO);

}
