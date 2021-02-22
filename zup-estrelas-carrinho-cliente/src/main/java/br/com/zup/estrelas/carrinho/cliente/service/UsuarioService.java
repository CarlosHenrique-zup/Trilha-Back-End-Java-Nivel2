package br.com.zup.estrelas.carrinho.cliente.service;

import java.util.List;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.UsuarioDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;

public interface UsuarioService {

	public MensagemDTO adicionarUsuario(UsuarioDTO usuarioDTO);

	public List<UsuarioEntity> listarUsuario();

	public MensagemDTO alteraUsuario(Long idUsuario, UsuarioDTO usuarioDTO);

	public MensagemDTO removerUsuario(Long idUsuario);
}
