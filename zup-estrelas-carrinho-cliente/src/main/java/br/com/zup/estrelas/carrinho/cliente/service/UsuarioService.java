package br.com.zup.estrelas.carrinho.cliente.service;

import java.util.List;

import br.com.zup.estrelas.carrinho.cliente.dto.LoginDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.UsuarioDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.ValidaUsuarioDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;

public interface UsuarioService {

	public MensagemDTO adicionarUsuario(UsuarioDTO usuarioDTO);

	public LoginDTO validarLogin(ValidaUsuarioDTO validaUsuarioDTO);

	public boolean validarUsuarioESenha(String nome, String senha);

	public List<UsuarioEntity> listarUsuario();

	public MensagemDTO alteraUsuario(Long idUsuario, UsuarioDTO usuarioDTO);

	public MensagemDTO removerUsuario(Long idUsuario);
}
