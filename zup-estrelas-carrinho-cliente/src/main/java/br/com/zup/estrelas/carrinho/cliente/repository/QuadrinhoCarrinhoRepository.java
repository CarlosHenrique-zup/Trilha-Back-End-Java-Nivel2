package br.com.zup.estrelas.carrinho.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoCarrinhoEntity;

@Repository
public interface QuadrinhoCarrinhoRepository extends CrudRepository<QuadrinhoCarrinhoEntity, Long> {

}
