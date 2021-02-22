package br.com.zup.estrelas.carrinho.cliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.UsuarioDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.UsuarioEntity;
import br.com.zup.estrelas.carrinho.cliente.exceptions.GenericException;
import br.com.zup.estrelas.carrinho.cliente.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO adicionarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws GenericException {
		return usuarioService.adicionarUsuario(usuarioDTO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<UsuarioEntity> listarUsuario() throws GenericException {
		return usuarioService.listarUsuario();
	}

	@PutMapping(path = "/{idUsuario}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alterarUsuario(@PathVariable Long idUsuario, @Valid @RequestBody UsuarioDTO usuarioDTO)
			throws GenericException {
		return usuarioService.alteraUsuario(idUsuario, usuarioDTO);
	}

	@DeleteMapping(path = "/{idUsuario}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removerUsuario(@PathVariable Long idUsuario) throws GenericException {
		return usuarioService.removerUsuario(idUsuario);
	}

}
