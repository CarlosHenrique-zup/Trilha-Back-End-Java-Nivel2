package br.com.zup.estrelas.carrinho.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.carrinho.cliente.dto.LoginDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.ValidaUsuarioDTO;
import br.com.zup.estrelas.carrinho.cliente.service.UsuarioService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping
	public LoginDTO login(@RequestBody ValidaUsuarioDTO validaUsuarioDTO) {
		return usuarioService.validarLogin(validaUsuarioDTO);

	}

//	@PostMapping
//	public LoginDTO login(@RequestParam("nome") String username, @RequestParam("senha") String pwd) {
//		if (!usuarioService.validarUsuarioESenha(username, pwd)) {
//			return null;
//		}
//		String token = getJWTToken(username);
//		LoginDTO user = new LoginDTO();
//		user.setUsername(username);
//		user.setToken(token);
//
//		return user;
//
//	}

}
