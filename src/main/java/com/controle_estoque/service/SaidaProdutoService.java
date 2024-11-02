package com.controle_estoque.service;

import com.controle_estoque.dto.SaidaProdutoDTO;
import com.controle_estoque.entity.Produto;
import com.controle_estoque.entity.SaidaProduto;
import com.controle_estoque.repository.ProdutoRepository;
import com.controle_estoque.repository.SaidaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaidaProdutoService {

    private final SaidaProdutoRepository saidaProdutoRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public SaidaProdutoService(SaidaProdutoRepository saidaProdutoRepository, ProdutoRepository produtoRepository) {
        this.saidaProdutoRepository = saidaProdutoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<SaidaProduto> listarSaidas() {
        return saidaProdutoRepository.findByAtivoTrue();
    }

    public SaidaProduto registrarSaida(SaidaProdutoDTO saidaProdutoDTO) {
        Produto produto = produtoRepository.findById(saidaProdutoDTO.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + saidaProdutoDTO.getProdutoId()));

        if (produto.getQuantidadeEstoque() < saidaProdutoDTO.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
        }
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - saidaProdutoDTO.getQuantidade());
        produtoRepository.save(produto);

        SaidaProduto saidaProduto = new SaidaProduto(produto, saidaProdutoDTO.getQuantidade(), saidaProdutoDTO.getDataSaida(), true);
        return saidaProdutoRepository.save(saidaProduto);
    }

    public Optional<SaidaProduto> encontrarSaidaPorId(Long id) {
        return saidaProdutoRepository.findById(id);
    }

    public void excluirSaida(Long id) {
        SaidaProduto saidaProduto = saidaProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Saída de produto não encontrada com ID: "));
        saidaProduto.setAtivo(false);
        saidaProdutoRepository.save(saidaProduto);
    }
}

