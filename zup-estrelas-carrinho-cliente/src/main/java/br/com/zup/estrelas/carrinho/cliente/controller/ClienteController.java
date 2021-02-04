package br.com.zup.estrelas.carrinho.cliente.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String helloWorld() {
		return "Hello World";
	}

}
