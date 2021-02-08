package br.com.zup.estrelas.carrinho.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoEntity;

@Repository
public interface QuadrinhoRepository extends CrudRepository<QuadrinhoEntity, Long> {

	boolean existsByNome(String nome);
}
