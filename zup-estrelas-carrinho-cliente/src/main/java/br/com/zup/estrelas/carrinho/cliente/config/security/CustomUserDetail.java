package br.com.zup.estrelas.carrinho.cliente.config.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.ClienteRepository;
import br.com.zup.estrelas.carrinho.cliente.repository.UsuarioRepository;

@Component
public class CustomUserDetail implements UserDetailsService {

	private ClienteRepository clienteRepository = null;

	private UsuarioRepository usuarioRepository;

	@Autowired
	public void CurstomUserDetailService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity usuario = Optional.ofNullable(usuarioRepository.findByNome(username))
				.orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado!"));
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

		return null;
	}

}
