package br.com.zup.estrelas.carrinho.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.carrinho.cliente.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

	boolean findByCpf(String cpf);

	boolean existsByCpf(String cpf);

	// Optional<ClienteEntity> findByEmail(String email);

	// boolean existsByEmail(String email);

//	ClienteEntity findByNome(String nome);
}
