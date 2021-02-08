package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.CarrinhoRepository;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	@Autowired
	CarrinhoRepository carrinhoRepository;

	@Override
	public List<CarrinhoEntity> listarCarrinhos() {
		return (List<CarrinhoEntity>) carrinhoRepository.findAll();
	}

}
