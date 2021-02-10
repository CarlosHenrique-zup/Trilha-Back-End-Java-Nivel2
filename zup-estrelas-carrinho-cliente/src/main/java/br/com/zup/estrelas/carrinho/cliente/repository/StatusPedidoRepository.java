package br.com.zup.estrelas.carrinho.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.carrinho.cliente.entity.StatusPedidoEntity;

@Repository
public interface StatusPedidoRepository extends CrudRepository<StatusPedidoEntity, Long> {

	boolean existsByNome(String nome);
}
