package br.com.zup.estrelas.carrinho.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;

@Repository
public interface CarrinhoRepository extends CrudRepository<CarrinhoEntity, Long> {

	@Query("SELECT c FROM CarrinhoEntity c")
	List<CarrinhoEntity> findAll();

	boolean existsByNome(String nome);

	boolean existsByIdCarrinho(Long idCarrinho);
}
