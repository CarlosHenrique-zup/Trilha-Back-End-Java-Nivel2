package br.com.zup.estrelas.carrinho.cliente.service;

import java.util.List;

import br.com.zup.estrelas.carrinho.cliente.dto.CarrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;

public interface CarrinhoService {

	public MensagemDTO adicionarCarrinho(CarrinhoDTO carrinhoDTO);

	public List<CarrinhoEntity> listarCarrinhos();

	public MensagemDTO alterarCarrinho(Long idCarrinho, CarrinhoDTO carrinhoDTO);

	public MensagemDTO removerCarrinho(Long idCarrinho);
}
