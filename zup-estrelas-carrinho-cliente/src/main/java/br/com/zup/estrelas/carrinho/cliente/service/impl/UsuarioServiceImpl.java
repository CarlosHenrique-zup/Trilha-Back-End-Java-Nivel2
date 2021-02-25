package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.dto.LoginDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.UsuarioDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.ValidaUsuarioDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.LoginRepository;
import br.com.zup.estrelas.carrinho.cliente.repository.UsuarioRepository;
import br.com.zup.estrelas.carrinho.cliente.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final String USUARIO_CADASTRADO_COM_SUCESSO = "Usuario cadastrado com sucesso!";
	private static final String USUARIO_LOGADO_COM_SUCESSO = "Usuario logado com sucesso!";
	private static final String USUARIO_REMOVIDO_COM_SUCESSO = "Usuario removido com sucesso!";
	private static final String USUARIO_COM_NOME_E_SENHA_INEXISTENTE = "Usuario com nome e senha inexistente!";
	private static final String USUARIO_ALTERADO_COM_SUCESSO = "Usuario alterado com sucesso!";
	private static final String USUARIO_INEXISTENTE = "Usuario inexistente!";
	private static final String USUARIO_JA_EXISTENTE = "Usuario já existente!";

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	LoginRepository loginRepository;

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

	public LoginDTO validarLogin(ValidaUsuarioDTO validaUsuarioDTO) {
		if (!this.validarUsuarioESenha(validaUsuarioDTO.getNome(), validaUsuarioDTO.getSenha())) {
			return null;
		}
		String token = getJWTToken(validaUsuarioDTO.getNome());
		LoginDTO user = new LoginDTO();
		user.setUsername(validaUsuarioDTO.getNome());
		user.setToken(token);

		return user;
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	public boolean validarUsuarioESenha(String nome, String senha) {
		UsuarioEntity usuario = new UsuarioEntity();

		Optional<UsuarioEntity> usuarioConsultado = loginRepository.findByNomeAndSenha(nome, senha);

		if (usuarioConsultado.isEmpty()) {
			return false;
		}

		return true;
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
