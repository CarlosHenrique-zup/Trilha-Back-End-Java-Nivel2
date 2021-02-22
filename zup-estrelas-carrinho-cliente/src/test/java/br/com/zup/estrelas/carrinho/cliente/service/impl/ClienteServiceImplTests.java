package br.com.zup.estrelas.carrinho.cliente.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.zup.estrelas.carrinho.cliente.dto.ClienteDTO;
import br.com.zup.estrelas.carrinho.cliente.repository.ClienteRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceImplTests {

	private static final String CLIENTE_CADASTRADO_COM_SUCESSO = "Cliente cadastrado com sucesso!";
	private static final String CLIENTE_REMOVIDO_COM_SUCESSO = "Cliente removido com sucesso!";
	private static final String CLIENTE_ALTERADO_COM_SUCESSO = "Cliente alterado com sucesso!";
	private static final String CLIENTE_INEXISTENTE = "Cliente inexistente!";
	private static final String CLIENTE_JA_EXISTENTE = "Cliente já existente!";

	@Mock
	ClienteRepository clienteRepository;

	private ClienteDTO gerarCliente() {
		ClienteDTO cliente = new ClienteDTO();
		cliente.setNome("Junior Alonso");
		cliente.setEndereco("Rua das Pedras");
		cliente.setIdade(15);
		cliente.setCpf("4242343243");
		cliente.setTelefone("2093-0930");
		return cliente;
	}

	@Test
	public void deveAdicionarClienteComSucesso() {

	}

	@Test
	public void naoDeveAdicionarClienteJaExistente() {

	}

	@Test
	public void deveAlterarClienteComSucesso() {

	}

	@Test
	public void naoDeveAlterarClienteInexistente() {

	}

	@Test
	public void deveRemoverClienteComSucesso() {

	}

	@Test
	public void naoDeveRemoverClienteInexistente() {

	}

}
