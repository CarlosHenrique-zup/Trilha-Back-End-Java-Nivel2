package br.com.zup.estrelas.carrinho.cliente.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.carrinho.cliente.dto.MensagemDTO;
import br.com.zup.estrelas.carrinho.cliente.dto.QuadrinhoDTO;
import br.com.zup.estrelas.carrinho.cliente.entity.CarrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.entity.QuadrinhoEntity;
import br.com.zup.estrelas.carrinho.cliente.repository.CarrinhoRepository;
import br.com.zup.estrelas.carrinho.cliente.repository.QuadrinhoRepository;
import br.com.zup.estrelas.carrinho.cliente.service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	private static final String QUADRINHO_CADASTRADO_COM_SUCESSO = "Quadrinho cadastrado com sucesso!";
	private static final String QUADRINHO_REMOVIDO_COM_SUCESSO = "Quadrinho removido com sucesso!";
	private static final String QUADRINHO_INEXISTENTE = "Quadrinho inexistente!";
	private static final String QUADRINHO_JA_EXISTENTE = "Quadrinho já existente!";
	private static final String QUADRINHO_JA_CADASTRADO_NO_CARRINHO = "Quadrinho já cadastrado!";
	private static final String QUADRINHO_ALTERADO_COM_SUCESSO = "Quadrinho alterado com sucesso!";

	@Autowired
	CarrinhoRepository carrinhoRepository;

	@Autowired
	QuadrinhoRepository quadrinhoRepository;

	public MensagemDTO adicionarQuadrinho(QuadrinhoDTO quadrinhoDTO) {
		QuadrinhoEntity quadrinho = new QuadrinhoEntity();

		if (quadrinhoRepository.existsById(quadrinho.getIdQuadrinho())) {
			return new MensagemDTO(QUADRINHO_JA_EXISTENTE);
		}

		BeanUtils.copyProperties(quadrinhoDTO, quadrinho);

		quadrinhoRepository.save(quadrinho);

		return new MensagemDTO(QUADRINHO_CADASTRADO_COM_SUCESSO);
	}

	public List<CarrinhoEntity> listarCarrinho() {
		return (List<CarrinhoEntity>) carrinhoRepository.findAll();
	}

	public MensagemDTO alterarQuadrinho(Long idQuadrinho, QuadrinhoDTO quadrinhoDTO) {
		Optional<QuadrinhoEntity> quadrinhoConsultado = quadrinhoRepository.findById(idQuadrinho);

		if (quadrinhoConsultado.isEmpty()) {
			return new MensagemDTO(QUADRINHO_INEXISTENTE);
		}

		QuadrinhoEntity quadrinhoAlterado = quadrinhoConsultado.get();
		BeanUtils.copyProperties(quadrinhoDTO, quadrinhoAlterado);

		quadrinhoRepository.save(quadrinhoAlterado);

		return new MensagemDTO(QUADRINHO_ALTERADO_COM_SUCESSO);
	}
//
//	public MensagemDTO removerQuadrinho(Long idCarrinho) {
//		boolean verificarExistenciaQuadrinhoNoCarrinho = !carrinhoRepository.findAllByQuadrinhoIdQuadrinho(idCarrinho)
//				.isEmpty();
//		boolean verificarInexistenciaQuadrinho = !quadrinhoRepository.existsById(idCarrinho);
//
//		if (verificarInexistenciaQuadrinho) {
//			return new MensagemDTO(QUADRINHO_INEXISTENTE);
//		}
//
//		if (verificarExistenciaQuadrinhoNoCarrinho) {
//			return new MensagemDTO(QUADRINHO_JA_CADASTRADO_NO_CARRINHO);
//		}
//
//		quadrinhoRepository.deleteById(idCarrinho);
//		return new MensagemDTO(QUADRINHO_REMOVIDO_COM_SUCESSO);
//
//	}

}
