package br.com.zup.estrelas.carrinho.cliente.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.repository.QuadrinhoRepository;

@RunWith(MockitoJUnitRunner.class)
public class QuadrinhoServiceImplTests {

	private static final String QUADRINHO_CADASTRADO_COM_SUCESSO = "Quadrinho cadastrado com sucesso!";
	private static final String QUADRINHO_JA_EXISTENTE = "Quadrinho já existente!";
	private static final String QUADRINHO_INEXISTENTE = "Quadrinho inexistente!";
	private static final String QUADRINHO_ALTERADO_COM_SUCESSO = "Quadrinho alterado com sucesso!";
	private static final String QUADRINHO_REMOVIDO_COM_SUCESSO = "Quadrinho removido com sucesso!";

	@Mock
	QuadrinhoRepository quadrinhoRepository;

	@InjectMocks
	QuadrinhoServiceImpl quadrinhoService;

	private QuadrinhoDTO gerarQuadrinho() {
		QuadrinhoDTO quadrinho = new QuadrinhoDTO();
		quadrinho.setNome("HQ Batman");
		quadrinho.setDescricao("História em quadrinhos do Batman");
		quadrinho.setNumPaginas(230);
		quadrinho.setPreco(230.00);
		quadrinho.setQuantidade(100);
		return quadrinho;
	}

	@Test
	public void deveAdicionarUmQuadrinhoComSucesso() {

	}

	@Test
	public void naoDeveAdicionarQuadrinhoJaExistente() {

	}

	@Test
	public void deveAlterarUmQuadrinhoComSucesso() {

	}

	@Test
	public void naoDeveAlterarUmQuadrinhoInexistente() {

	}

	@Test
	public void deveRemoverQuadrinhoComSucesso() {

	}

	@Test
	public void naoDeveRemoverQuadrinhoInexistente() {

	}

	@Test
	public void naoDeveRemoverQuadrinhoCadastradoEmCarrinho() {

	}
}
