package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoCarrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoCarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.QuadrinhoCarrinhoRepository;
import br.com.zup.estrelas.carrinho.cliente.service.QuadrinhoCarrinhoService;

@Service
public class QuadrinhoCarrinhoServiceImpl implements QuadrinhoCarrinhoService {

	private static final String QUADRINHO_CARRINHO_CADASTRADO_COM_SUCESSO = "Quadrinho carrinho cadastrado com sucesso!";
	private static final String QUADRINHO_CARRINHO_REMOVIDO_COM_SUCESSO = "Quadrinho carrinho removido com sucesso!";
	private static final String QUADRINHO_CARRINHO_ALTERADO_COM_SUCESSO = "Quadrinho carrinho alterado com sucesso!";
	private static final String QUADRINHO_CARRINHO_JA_EXISTENTE = "Quadrinho já existente!";
	private static final String QUADRINHO_CARRINHO_INEXISTENTE = "Quadrinho inexistente!";

	@Autowired
	QuadrinhoCarrinhoRepository quadrinhoCarrinhoRepository;

	public MensagemDTO adicionarQuadrinhoCarrinho(QuadrinhoCarrinhoDTO carrinhoQuadrinhoDTO) {
		QuadrinhoCarrinhoEntity quadrinhoCarrinho = new QuadrinhoCarrinhoEntity();

		if (quadrinhoCarrinhoRepository.existsById(carrinhoQuadrinhoDTO.getIdQuadrinhoCarrinho())) {
			return new MensagemDTO(QUADRINHO_CARRINHO_JA_EXISTENTE);
		}

		BeanUtils.copyProperties(carrinhoQuadrinhoDTO, quadrinhoCarrinho);

		quadrinhoCarrinhoRepository.save(quadrinhoCarrinho);

		return new MensagemDTO(QUADRINHO_CARRINHO_CADASTRADO_COM_SUCESSO);
	}

	public List<QuadrinhoCarrinhoEntity> listarQuadrinhoCarrinho() {
		return (List<QuadrinhoCarrinhoEntity>) quadrinhoCarrinhoRepository.findAll();
	}

	public MensagemDTO alterarQuadrinhoCarrinho(Long idQuadrinhoCarrinho, QuadrinhoCarrinhoDTO quadrinhoCarrinhoDTO) {
		Optional<QuadrinhoCarrinhoEntity> quadrinhoCarrinhoConsultado = quadrinhoCarrinhoRepository
				.findById(idQuadrinhoCarrinho);

		if (quadrinhoCarrinhoConsultado.isEmpty()) {
			return new MensagemDTO(QUADRINHO_CARRINHO_INEXISTENTE);
		}

		QuadrinhoCarrinhoEntity quadrinhoCarrinhoAlterado = quadrinhoCarrinhoConsultado.get();
		BeanUtils.copyProperties(quadrinhoCarrinhoDTO, quadrinhoCarrinhoAlterado);

		return new MensagemDTO(QUADRINHO_CARRINHO_ALTERADO_COM_SUCESSO);
	}

	public MensagemDTO removerQuadrinhoCarrinho(Long idQuadrinhoCarrinho) {
		if (quadrinhoCarrinhoRepository.existsById(idQuadrinhoCarrinho)) {
			quadrinhoCarrinhoRepository.deleteById(idQuadrinhoCarrinho);
		}

		return new MensagemDTO(QUADRINHO_CARRINHO_REMOVIDO_COM_SUCESSO);
	}

}
