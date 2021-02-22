package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.UsuarioDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.UsuarioRepository;
import br.com.zup.estrelas.carrinho.cliente.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final String USUARIO_CADASTRADO_COM_SUCESSO = "Usuario cadastrado com sucesso!";
	private static final String USUARIO_REMOVIDO_COM_SUCESSO = "Usuario removido com sucesso!";
	private static final String USUARIO_ALTERADO_COM_SUCESSO = "Usuario alterado com sucesso!";
	private static final String USUARIO_INEXISTENTE = "Usuario inexistente!";
	private static final String USUARIO_JA_EXISTENTE = "Usuario já existente!";

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public MensagemDTO adicionarUsuario(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuario = new UsuarioEntity();

		if (usuarioRepository.existsByEmail(usuario.getEmail())) {
			return new MensagemDTO(USUARIO_JA_EXISTENTE);
		}

		BeanUtils.copyProperties(usuarioDTO, usuario);
		usuarioRepository.save(usuario);

		return new MensagemDTO(USUARIO_CADASTRADO_COM_SUCESSO);

	}

	@Override
	public List<UsuarioEntity> listarUsuario() {
		return (List<UsuarioEntity>) usuarioRepository.findAll();
	}

	@Override
	public MensagemDTO alteraUsuario(Long idUsuario, UsuarioDTO usuarioDTO) {
		Optional<UsuarioEntity> usuarioConsultado = usuarioRepository.findById(idUsuario);

		if (usuarioConsultado.isEmpty()) {
			return new MensagemDTO(USUARIO_INEXISTENTE);
		}

		UsuarioEntity usuarioAlterado = usuarioConsultado.get();
		BeanUtils.copyProperties(usuarioDTO, usuarioAlterado);

		return new MensagemDTO(USUARIO_ALTERADO_COM_SUCESSO);
	}

	@Override
	public MensagemDTO removerUsuario(Long idUsuario) {
		if (usuarioRepository.existsById(idUsuario)) {
			usuarioRepository.deleteById(idUsuario);
		}

		return new MensagemDTO(USUARIO_REMOVIDO_COM_SUCESSO);
	}

}
