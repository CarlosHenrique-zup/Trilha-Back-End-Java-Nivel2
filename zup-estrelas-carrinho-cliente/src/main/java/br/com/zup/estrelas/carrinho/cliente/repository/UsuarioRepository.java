package br.com.zup.estrelas.carrinho.cliente.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

	boolean existsByEmail(String email);

	UsuarioEntity findByUsername(String username);

	Optional<UsuarioEntity> findByEmail(String email);

	UsuarioEntity findByNome(String nome);
}
