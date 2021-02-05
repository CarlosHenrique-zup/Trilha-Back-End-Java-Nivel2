package br.com.zup.estrelas.carrinho.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;

@Repository
public interface CarrinhoRepository extends CrudRepository<CarrinhoEntity, Long> {

//	List<CarrinhoEntity> findAllByQuadrinhoIdQuadrinho(Long idQuadrinho);
}
