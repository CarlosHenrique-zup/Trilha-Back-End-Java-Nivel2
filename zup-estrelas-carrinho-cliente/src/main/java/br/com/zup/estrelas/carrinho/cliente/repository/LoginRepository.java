package br.com.zup.estrelas.carrinho.cliente.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;

@Repository
public interface LoginRepository extends CrudRepository<UsuarioEntity, Long> {

	Optional<UsuarioEntity> findByNomeAndSenha(String nome, String senha);

	boolean findDistinctByNomeAndSenha(String nome, String senha);
}
