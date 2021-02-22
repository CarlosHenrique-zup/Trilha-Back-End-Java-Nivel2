package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.ClienteRepository;
import br.com.zup.estrelas.carrinho.cliente.repository.UsuarioRepository;

@Service
public class AutenticacaoServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioEntity> cliente = usuarioRepository.findByEmail(username);
		return null;
	}

}
